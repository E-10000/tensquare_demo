package com.tensquare_base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
=======
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
>>>>>>> ed90e21... v1.0.0
import org.springframework.context.annotation.Bean;
import util.IdWorker;

import javax.swing.*;

@SpringBootApplication
<<<<<<< HEAD
=======
@EnableEurekaClient
>>>>>>> ed90e21... v1.0.0
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
