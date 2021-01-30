package com.software.ronggateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class HeaderHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        if (fullRequest.uri().startsWith("/controller/admin/")){
            fullRequest.setUri("/controller/prod");
        }else{
            fullRequest.setUri("/controller/test");
        }
    }
}
