package com.movie.crawling.Utils;

import org.apache.commons.lang.StringUtils;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.OfficeException;
import org.artofsolving.jodconverter.office.OfficeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Office2PDFUtils {

    private static Logger logger = LoggerFactory.getLogger(Office2PDFUtils.class);

    @Autowired
    private InitOpenOfficeUtil initOpenOfficeUtil;

    /**
     * @Description: 使Office2003-2007全部格式的文档(.doc|.docx|.xls|.xlsx|.ppt|.pptx) 转化为pdf文件
     * @method: openOfficeToPDF
     * @Param: inputFilePath
     * @Param: outputFilePath
     * @return: boolean
     * @auther: LHL
     */
    public boolean openOfficeToPDF(String inputFilePath, String outputFilePath) {
        return office2Pdf(inputFilePath, outputFilePath);
    }


    /**
     * @Description: 转换文件
     * @method: convertFile
     * @Param: inputFile
     * @Param: outputFilePath
     * @Param: officeManager
     * @return: java.io.File
     * @auther: LHL
     */
    private File convertFile(File inputFile, String outputFilePath, OfficeManager officeManager) throws OfficeException {
        File outputFile = new File(outputFilePath);
        // 假如目标路径不存在,则新建该路径
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }
        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        converter.convert(inputFile, outputFile);
        initOpenOfficeUtil.put(officeManager);
        logger.debug("blockingQueue puted OfficeManagerQueue size :" + initOpenOfficeUtil.size());
        logger.debug("文件：" + inputFile.getAbsolutePath() + "\n转换为目标文件：" + outputFile + "\n成功!");
        return outputFile;
    }

    /**
     * 文件名需要唯一
     */
    public boolean office2Pdf(String inputFilePath, String outputFilePath) {
        OfficeManager officeManager = null;
        try {
            if (StringUtils.isEmpty(inputFilePath)) {
                logger.debug("输入文件地址为空，转换终止!");
                return false;
            }
            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                logger.debug("输入文件不存在，转换终止!");
                return false;
            }
            officeManager = initOpenOfficeUtil.take();
            logger.debug("blockingQueue taked , OfficeManagerQueue size :" + initOpenOfficeUtil.size());
            File file = convertFile(inputFile, outputFilePath, officeManager);
            if (!file.exists()) {
                logger.debug("转换文件不存在!转换失败!!");
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("转换异常");
            initOpenOfficeUtil.put(officeManager);
            logger.debug("blockingQueue puted OfficeManagerQueue size :" + initOpenOfficeUtil.size());
            return false;
        }
    }
}
