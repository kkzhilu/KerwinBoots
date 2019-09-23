package redisServer;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/22 21:47
 * description:  SocketApp 监听 端口信息
 * version:      V1.0
 * ******************************
 */
public class SocketApp {

    /***
     * 监听 6379 传输的数据
     * JVM端口需要进行设置
     */
    public static void main(String[] args)  {
        try {
            ServerSocket serverSocket = new ServerSocket(6379);
            Socket redis = serverSocket.accept();
            byte[] result = new byte[2048];
            redis.getInputStream().read(result);
            System.out.println(new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
