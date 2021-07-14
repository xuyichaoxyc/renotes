package chapter01_network;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/6 17:25
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Client c = new Client("127.0.0.1", 8080);
        c.connect();
    }
}

class Client {
    String ip;
    int port;
    Socket server = null;
    Boolean isConnected;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void connect() throws IOException {
        Socket server = new Socket(ip, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter out = new PrintWriter(server.getOutputStream());
        BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));

        if (server.isConnected()) {
            isConnected = true;
            System.out.println("服务器信息：" + in.readLine());
        }
        while (isConnected) {
            System.out.println("服务器信息" + in.readLine());
            System.out.println("请输入>");
            String str = wt.readLine();
            if (str.equals("quit")) {
                isConnected = false;
            }
            out.println(str);
            out.flush();
        }

        out.close();
        in.close();
        wt.close();
        server.close();
    }
}