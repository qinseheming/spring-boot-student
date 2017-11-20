package com.spring.boot.yangming;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.boot.yangming.dao")//扫描：该包下相应的class,主要是MyBatis的持久化类.
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);	
    }
}
