package com.rongsoft.week2.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpClientDemo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URI uri = new URI("http://127.0.0.1:8801");
        HttpGet httpGet = new HttpGet(uri);
        HttpResponse response = httpClient.execute(httpGet);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String lineString = "";
        while ((lineString = bufferedReader.readLine()) != null) {
            System.out.println(lineString);

        }
    }
}
