package com.rongsoft.dts.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.rongsoft.dts.demo.dao.mapper")
public class DemoApplication {
    //设置AOP相关参数, expose-proxy="true"    proxy-target-class="true" 这两个参数
    // expose-proxy="true" 时 可以支持通过代理类调用,要不然报错
    // Cannot find current proxy: Set 'exposeProxy' property on Advised to 'true' to make it available,
    // and ensure that AopContext.currentProxy() is invoked in the same thread as the AOP invocation context.
    // CardBinService cardBinService = (CardBinService) AopContext.currentProxy();
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
