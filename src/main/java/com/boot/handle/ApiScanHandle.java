package com.boot.handle;

import com.boot.annotation.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Objects;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/11/22 16:51
 * description:  ApiScanHandle
 * version:      V1.0
 * ******************************
 */
@Component
public class ApiScanHandle implements CommandLineRunner {

    @Value("${scanPackage}")
    private String path;

    @Override
    public void run(String... args) throws Exception {
        // 扫描目录
        doScanner(path);

        // 构建对象
        doInstance();

        // 存储对象方法
        initHandlerMapping();
    }

    /***
     * 扫描目录
     */
    private void doScanner (String rootPath) throws ServletException, FileNotFoundException {
        URL url = this.getClass().getClassLoader().getResource(rootPath.replaceAll("\\.", "/"));
        File file = new File(Objects.requireNonNull(url).getFile());
        if (!file.isDirectory()) {
            throw new ServletException("Base Package is wrong.");
        }

        for (File current : Objects.requireNonNull(file.listFiles())) {
            if (current.isDirectory()) {
                doScanner(rootPath + "." + current.getName());
            } else {
                String className = rootPath + "." + current.getName().replace(".class", "");
                ApiDataUtil.getClassNames().add(className);
            }
        }
    }

    /***
     * 构建对象
     */
    private void doInstance () {
        if (ApiDataUtil.getClassNames().isEmpty()) {
            return;
        }

        try {
            for (String className : ApiDataUtil.getClassNames()) {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(Api.class)) {
                    ApiDataUtil.getIocFactory().put(clazz.getSimpleName(), clazz.newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 将bean和method联系起来
     */
    private void initHandlerMapping () {
        if (ApiDataUtil.getIocFactory().isEmpty()) {
            return;
        }

        for (String key : ApiDataUtil.getIocFactory().keySet()) {
            Class<? extends Object> clazz = ApiDataUtil.getIocFactory().get(key).getClass();
            if (!clazz.isAnnotationPresent(Api.class)) {
                continue;
            }

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                ApiDataUtil.getHandleMapping().put(key + "-" + method.getName(), method);
            }
        }
    }
}
