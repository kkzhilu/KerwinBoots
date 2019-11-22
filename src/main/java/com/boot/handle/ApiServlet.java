package com.boot.handle;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.time.StopWatch;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/11/22 15:53
 * description:  Api Servlet
 * version:      V1.0
 * ******************************
 */
public class ApiServlet extends HttpServlet {

    private static final String ACTION = "action";

    private static final String METHOD = "method";

    private static final String DATA   = "data";

    /***
     * 地  址：http://localhost:8080
     * 请求体：
     * {
     *   "action": "ApiDemo",
     *   "method": "testList",
     *   "data": {
     *     "page":1,
     *     "pageSize":10
     *   }
     * }
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StopWatch watch = new StopWatch();
        watch.start();

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        try {
            JSONObject jsonObject = JSONObject.parseObject(stringBuilder.toString());

            if (jsonObject.containsKey(ACTION) && jsonObject.containsKey(METHOD)) {
                String action = jsonObject.getString(ACTION);
                String method = jsonObject.getString(METHOD);
                String key = action + "-" + method;
                if (ApiDataUtil.getHandleMapping().containsKey(key)) {

                    JSONObject data = jsonObject.getJSONObject(DATA);

                    if (data == null) {
                        data = new JSONObject();
                    }

                    Object invoke = ApiDataUtil.getHandleMapping().get(key).invoke(ApiDataUtil.getIocFactory().get(action), data);
                    response.getWriter().write(invoke.toString());
                    return;
                }
            }

            response.getWriter().write("Error Method.");

        } catch (JSONException | IllegalAccessException | InvocationTargetException e) {
            throw new IOException("Error parsing JSON request string");
        }
    }
}
