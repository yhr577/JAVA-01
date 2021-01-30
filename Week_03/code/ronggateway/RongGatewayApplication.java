package com.software.ronggateway;


import com.software.ronggateway.inbound.HttpInboundServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RongGatewayApplication {
    
    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "3.0.0";
    
    public static void main(String[] args) {

        String proxyPort = System.getProperty("proxyPort","8888");

        // 这是多个后端url走随机路由的例子
        String proxyServers = System.getProperty("proxyServers","http://localhost:8088,http://localhost:8089");
        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        HttpInboundServer server = new HttpInboundServer(port, Arrays.asList(proxyServers.split(",")));
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for server:" + server.toString());
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
