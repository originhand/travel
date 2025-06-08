package com.jmj;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jmj.mapper")
@SpringBootApplication
public class VisitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(VisitorApplication.class,args);
    }
}
