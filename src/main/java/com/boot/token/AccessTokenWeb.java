package com.boot.token;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boot.wechat.NetWorkHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/12 16:16
 * description:  AccessToken Get
 * version:      V1.0
 * ******************************
 */
@Component
public class AccessTokenWeb {

    private static AccessToken ACCESS_TOKEN = null;

    @PostConstruct
    private void init () {
        final String appId = "wx593dea49d2327c47";
        final String appSecret = "a750b93187ff57e77001e70b90dfa6c7";

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit((Runnable) () -> {
            while (true) {
                try {
                    AccessTokenWeb.ACCESS_TOKEN = getAccessToken(appId, appSecret);
                    if (AccessTokenWeb.ACCESS_TOKEN != null) {
                        // 获取到access_token 休眠7000秒,大约2个小时左右
                        Thread.sleep(7000 * 1000);
                    } else {
                        // 获取失败
                        Thread.sleep(1000 * 3);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), new Throwable(e));
                }
            }
        });
    }

    private AccessToken getAccessToken(String appId, String appSecret) {

        /**
         * 接口地址为https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET，其中grant_type固定写为client_credential即可。
         */
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId, appSecret);

        //此请求为https的get请求，返回的数据格式为{"access_token":"ACCESS_TOKEN","expires_in":7200}
        String result = NetWorkHelper.getHttpsResponse(Url, "");
        logger.info("access_token = " + result);

        //使用FastJson将Json字符串解析成Json对象
        JSONObject json = JSON.parseObject(result);

        AccessToken token = new AccessToken();
        token.setAccessToken(json.getString("access_token"));
        token.setExpiresin(json.getInteger("expires_in"));
        return token;
    }

    private class AccessToken {
        private String accessToken;

        private int expiresin;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public int getExpiresin() {
            return expiresin;
        }

        public void setExpiresin(int expiresin) {
            this.expiresin = expiresin;
        }
    }

    private static Logger logger = LoggerFactory.getLogger(AccessTokenWeb.class);
}
