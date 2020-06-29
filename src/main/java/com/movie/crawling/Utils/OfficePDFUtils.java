package com.movie.crawling.Utils;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.ConnectException;

@Component
public class OfficePDFUtils {

    private static final Logger logger = LoggerFactory.getLogger(OfficePDFUtils.class);

    /**
     * office办公软件格式
     */
    private static String[] docFile =
            {".txt", ".doc", ".docx", ".wps", ".xls", ".xlsx", ".et", ".ppt", ".pptx", ".dps"};

    /**
     * 文件地址
     * @param ip
     * @param port
     * @param sourceFile
     * @param destFile
     * @return
     */
    public static boolean office2PDF(String ip, int port, String sourceFile, String destFile) {
        try {
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                logger.info("找不到源文件");
                return false;
            }
            // 如果目标路径不存在, 则新建该路径
            File outputFile = new File(destFile);
            if (!outputFile.getParentFile().exists()) {
                outputFile.getParentFile().mkdirs();

            }
            // connect to an OpenOffice.org instance running on port 8100
            OpenOfficeConnection connection = new SocketOpenOfficeConnection(ip, port);
            connection.connect();
            // convert
            DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
            converter.convert(inputFile, outputFile);
            // close the connection
            connection.disconnect();
            logger.info("路径：" + destFile);
            return true;
        } catch (ConnectException e) {
            logger.warn("ConnectException", e);
        }

        return true;
    }

    /**
     * 可解析的文件
     *
     * @param fileName
     * @return boolean
     * @author tang
     * @method isConvertible
     */
    public static boolean isConvertible(String fileName) {
        String after = fileName.substring(fileName.lastIndexOf("."));
        for (String type : docFile) {
            if (type.contains(after)) {
                return true;
            }
        }
        return false;
    }
}
