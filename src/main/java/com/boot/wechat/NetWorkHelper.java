package com.boot.wechat;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.X509Certificate;

/**
 * 访问网络用到的工具类，用来发起https请求，获取access_token
 * getHttpsResponse方法是请求一个https地址
 * 参数requestMethod为字符串“GET”或者“POST”，传null或者“”默认为get方式。
 */

public class NetWorkHelper {

    public static String getHttpsResponse(String reqUrl, String requestMethod) {
        URL url;
        InputStream is;
        StringBuilder resultData = new StringBuilder();
        try {
            url = new URL(reqUrl);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            TrustManager[] tm = {xtm};

            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(null, tm, null);

            con.setSSLSocketFactory(ctx.getSocketFactory());
            con.setHostnameVerifier((arg0, arg1) -> true);

            // 允许输入流，即允许下载
            con.setDoInput(true);

            // 在android中必须将此项设置为false
            con.setDoOutput(false);  //允许输出流，即允许上传
            con.setUseCaches(false); //不使用缓冲

            if (null != requestMethod && !requestMethod.equals("")) {
                con.setRequestMethod(requestMethod);
            } else {
                con.setRequestMethod("GET");
            }
            is = con.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bufferReader = new BufferedReader(isr);
            String inputLine;
            while ((inputLine = bufferReader.readLine()) != null) {
                resultData.append(inputLine).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultData.toString();
    }

    private static X509TrustManager xtm = new X509TrustManager() {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) { }

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) { }
    };
}