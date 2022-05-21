package xyz.immmmmmm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 扫描dao包
@MapperScan("xyz.immmmmmm.dao")
// 这是一个启动类
@SpringBootApplication
public class MyWebApplication {

    public static void main(String [] args){
        SpringApplication.run(MyWebApplication.class,args);
    }
}
