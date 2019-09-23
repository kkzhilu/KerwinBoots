package com.boot.meJedis;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/23 14:33
 * description:  CommandThread
 * version:      V1.0
 * ******************************
 */
public class CommandThread extends Thread {

    private OutputStream outputStream;

    private InputStream inputStream;

    public CommandThread (OutputStream outputStream, InputStream inputStream) {
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String command = ConfigUtil.getQueue().take();
                System.out.println("Redis Command is: " + command.trim());
                outputStream.write(command.getBytes());
                byte[] bytes = new byte[1024 * 2];
                inputStream.read(bytes);
                System.out.println("Result: " + new String(bytes));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
