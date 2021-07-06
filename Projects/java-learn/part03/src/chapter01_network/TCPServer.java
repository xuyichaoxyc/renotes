package chapter01_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/6 17:15
 */
public class TCPServer {
    public static void main(String[] args) {
        Server server = new Server(8080);
    }
}

class Server {
    private int port;

    public Server(int port) {
        this.port = port;
        start();
    }

    public String infoUpperCase(String line) {
        // 处理信息，将字符串大写
        return line.toUpperCase();
    }

    public void start() {
        try {
            // 根据端口创建服务器端 Socket 对象
            ServerSocket serverSocket = new ServerSocket(port);
            // 显示连接信息
            System.out.println("服务已启动，监听端口号为：" + port);
            System.out.println("正在等待客户端连接......");
            // 挂起等待客户的请求
            Socket socketAccept = serverSocket.accept();
            // 获取读取客户端的数据流
            BufferedReader in = new BufferedReader(new InputStreamReader(socketAccept.getInputStream()));
            // 获取写入客户端的数据输出流，参数true表示自动刷新输出缓冲区
            PrintWriter out = new PrintWriter(socketAccept.getOutputStream(), true);
            out.println("服务器端连接成功......");
            out.println("输入 quit 断开与服务器的连接");

            boolean done = false;
            while (!done) {
                String line = in.readLine();
                if (line == null) {
                    done = true;
                } else {
                    System.out.println("来自客户端的信息：" + line);
                    String message = infoUpperCase(line);
                    out.println("来自服务器端的信息：" + message);
                    if (line.trim().equals("quit")) {
                        done = true;
                    }
                }
            }
            socketAccept.close();
        } catch (IOException e) {
            System.out.println("启动服务器端出现错误：" + e.getMessage());
        }
    }
}
