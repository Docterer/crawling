package com.movie.crawling.Utils;

import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeException;
import org.artofsolving.jodconverter.office.OfficeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.regex.Pattern;

@Component
public class InitOpenOfficeUtil {
    private static Logger logger = LoggerFactory.getLogger(InitOpenOfficeUtil.class);

    @Value("${oppenOffice.winPath}")
    private String winPath;
    @Value("${oppenOffice.linuxPath}")
    private String linuxPath;
    @Value("${oppenOffice.port}")
    private String port;

    private static BlockingQueue<OfficeManager> OfficeManagerQueue = new LinkedBlockingDeque<>();
    /**
     * @Description: 根据操作系统的名称，获取OpenOffice.org 的安装目录
     * @method: getOfficeHome
     * @Param:
     * @return: java.lang.String OpenOffice.org 的安装目录
     * @auther: LHL
     */
    private String getOfficeHome() {
        String osName = System.getProperty("os.name");
        logger.debug("操作系统名称:" + osName);
        if (Pattern.matches("Linux.*", osName)) {
            return linuxPath;
        } else if (Pattern.matches("Windows.*", osName)) {
            return winPath;
        } else if (Pattern.matches("Mac.*", osName)) {
            return winPath;
        }
        return null;
    }

    /**
     * @Description: 在bean创建实例时, 连接OpenOffice.org 并且启动OpenOffice.org
     * @method: initOpenOfficeService
     * @Param:
     * @return: void
     * @auther: LHL
     */
    @PostConstruct
    public void initOpenOfficeService() {
        DefaultOfficeManagerConfiguration builder = new DefaultOfficeManagerConfiguration();
        builder.setOfficeHome(getOfficeHome());
        //设置任务执行超时为15分钟
        builder.setTaskExecutionTimeout(1000 * 60 * 15L);
        //设置任务队列超时为24小时
        builder.setTaskQueueTimeout(1000 * 60 * 60 * 24L);
        for (String port : port.split(",")) {
            builder.setPortNumbers(Integer.valueOf(port));
            OfficeManager OfficeManager = builder.buildOfficeManager();
            try {
                OfficeManager.start();
                logger.debug("***********************officeManager 启动!***********************");
            } catch (OfficeException e) {
                //打印日志
                logger.debug("***********************启动 openOffice 失败!***********************");
                e.printStackTrace();
            }
            try {
                OfficeManagerQueue.put(OfficeManager);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Description: bean销毁时停止
     * @method: destroyOpenOfficeService
     * @Param:
     * @return: void
     * @auther: LHL
     */
    @PreDestroy
    public void destroyOpenOfficeService() {
        for (OfficeManager manager : OfficeManagerQueue) {
            try {
                logger.debug("关闭所有 officeManager");
                manager.stop();
            } catch (OfficeException e) {
                logger.debug("officeManager 关闭 失败!" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public  OfficeManager  take(){
        OfficeManager take = null;
        try {
            take = OfficeManagerQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return take;
    }

    public  void  put(OfficeManager officeManager){
        try {
            OfficeManagerQueue.put(officeManager);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  int  size(){
        return  OfficeManagerQueue.size();
    }
}
