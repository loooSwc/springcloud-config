package com.cxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableConfigServer        // 声明是配置中心服务端
public class App{
    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }
}
