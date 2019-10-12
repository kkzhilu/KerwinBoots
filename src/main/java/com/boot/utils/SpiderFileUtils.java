package com.boot.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/9 17:15
 * description:  SpiderFileUtils
 * version:      V1.0
 * ******************************
 */
public class SpiderFileUtils {

    private static Logger logger = LoggerFactory.getLogger(SpiderFileUtils.class);

    /***
     * 下载文件
     * @param urlStr   Url地址
     * @param fileName fileNmae
     * @param savePath savePath
     * @param savePath cookie
     */
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath, String cookie) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // 设置超时间为3秒
        conn.setConnectTimeout(3 * 1000);

        // 防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        // 设置Cookie
        if (StringUtils.isNotBlank(cookie)) {
            conn.setRequestProperty("Cookie", cookie);
        }

        // 输入流
        InputStream inputStream = conn.getInputStream();

        // 文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        File file = new File(saveDir + File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);

        // 下载文件
        download(inputStream, fos);

        logger.info(fileName + " download success");
    }

    /**
     * downLoad File
     */
    private static void download(InputStream in, OutputStream out) {
        BufferedInputStream bis = new BufferedInputStream(in);
        byte[] b = new byte[1024];
        int n;
        try {
            while ((n = bis.read(b)) != -1) {
                out.write(b, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
