package com.boot.web;

import com.boot.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/12 15:53
 * description:  WeChat TokenHandle
 * version:      V1.0
 * ******************************
 */
@RestController
public class TokenHandleWeb {

    //定义token参数
    private static final String TOKEN = "123456";

    /***
     * 校验Token
     * @param signature  // 微信加密签名signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
     * @param timestamp  // 时间戳
     * @param nonce      // 随机数
     * @param echostr    // 随机字符串
     */
    @GetMapping("/wechat")
    public String validate (@RequestParam(value = "signature") String signature,
                            @RequestParam(value = "timestamp") String timestamp,
                            @RequestParam(value = "nonce")     String nonce,
                            @RequestParam(value = "echostr")   String echostr) {

        // 排序
        String sortString = sort(TOKEN, timestamp, nonce);

        // 加密
        String mySignature = sha1(sortString);

        // 校验签名
        if (StringUtils.isNotBlank(mySignature) && mySignature.equals(signature)) {
            logger.info("Token pass...  Now Time is: " + CommonUtils.getChineseDate());
            return echostr;
        }

        logger.info("Token wrong...  Now Time is: " + CommonUtils.getChineseDate());
        return null;
    }

    /**
     * 排序方法
     */
    private String sort(String token, String timestamp, String nonce) {
        String[] strArray = {token, timestamp, nonce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 将字符串进行sha1加密
     */
    private String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (byte aMessageDigest : messageDigest) {
                String shaHex = Integer.toHexString(aMessageDigest & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static Logger logger = LoggerFactory.getLogger(TokenHandleWeb.class);
}
