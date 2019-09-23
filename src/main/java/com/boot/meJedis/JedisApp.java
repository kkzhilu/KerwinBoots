package com.boot.meJedis;

import java.io.IOException;
import java.net.Socket;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/23 14:28
 * description:  JedisApp
 * version:      V1.0
 * ******************************
 */
public class JedisApp {

    public static void connect (String host, Integer port) throws IOException {
        Socket socket = new Socket(host, port);
        new CommandThread(socket.getOutputStream(), socket.getInputStream()).start();
    }
}

