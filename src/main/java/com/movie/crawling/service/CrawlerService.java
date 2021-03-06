package com.movie.crawling.service;

import com.alibaba.fastjson.JSONObject;
import com.movie.crawling.Utils.FileUtil;
import com.movie.crawling.entity.ContentImg;
import com.movie.crawling.entity.OnePunchMan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.*;
import java.net.URL;
import java.util.List;

@Service
public class CrawlerService implements PageProcessor {

    private String str;//爬取下来的json
    private String chapterName;

    private static Logger logger = LoggerFactory.getLogger(CrawlerService.class);// slf4j日志记录器

    @Override
    public void process(Page page) {
        logger.info("爬取成功，内容为：\n"+page.getRawText());
        str = page.getRawText();
    }

    @Override
    public Site getSite() {
        return Site.me().setCharset("UTF-8").setSleepTime(1000).setRetrySleepTime(3);
    }

    public String downLoadImage(CrawlerService crawlerService,String url) {
        logger.info("Service://downLoadImage  url:{}",url);

        Spider.create(crawlerService).addUrl(url).thread(1).run();
        //1.将JSON字符串转为JSON对象
        JSONObject json = JSONObject.parseObject(str.trim());
        //2.将json对象转为java实体类
        OnePunchMan onePunchMan = (OnePunchMan)JSONObject.toJavaObject(json,OnePunchMan.class);

        chapterName = "/Users/danyiran/Desktop/onePunch/" + onePunchMan.getData().getTitle();

        try{
            FileUtil.createNewFile(chapterName);
        }catch (IOException e){
            e.printStackTrace();
        }

        List<ContentImg> contentImgList = onePunchMan.getData().getContentImg();
        URL imageDownloadPath = null;
        for (ContentImg contentImg:contentImgList
             ) {
            try {
                imageDownloadPath = new URL(contentImg.getUrl());
                DataInputStream dataInputStream = new DataInputStream(imageDownloadPath.openStream());
                String imageName = chapterName + "/" + contentImg.getName();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;

                while ((length = dataInputStream.read(buffer)) > 0){
                    outputStream.write(buffer,0,length);
                }

                byte[] context = outputStream.toByteArray();
                fileOutputStream.write(outputStream.toByteArray());
                dataInputStream.close();
                fileOutputStream.close();

            }catch (Exception e){
                logger.error("错误:",e);
            }
        }

        logger.info("Service return onePunchMan:{}",onePunchMan);
        return "OK";
    }

    public void testService(CrawlerService crawlerService,String url){
        Spider.create(crawlerService).addUrl(url).thread(1).run();
//        try {
//            FileUtil.createNewFileFromInternet(url,);
//        }catch (IOException e){
//
//        }
        try {
            URL imageDownloadPath = new URL(url);
            DataInputStream dataInputStream = new DataInputStream(imageDownloadPath.openStream());
            String imageName = "/Users/danyiran/Desktop/mango/mango.html";
            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,length);
            }

            byte[] context = outputStream.toByteArray();
            fileOutputStream.write(outputStream.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();

        }catch (Exception e){
            logger.error("错误:",e);
        }

    }
}
