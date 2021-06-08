package com.xyc.learn.sub;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/8 15:29
 */
public class TestHttpClient {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        for(int i = 0; i < 6; i++){
            HttpGet httpGet = new HttpGet("http://localhost:9000/router");
            try {
                HttpResponse response = httpClient.execute(httpGet);
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
