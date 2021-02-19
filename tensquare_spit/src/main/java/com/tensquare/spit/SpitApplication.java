package com.tensquare.spit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
=======
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
>>>>>>> ed90e21... v1.0.0
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
<<<<<<< HEAD
=======
@EnableEurekaClient
>>>>>>> ed90e21... v1.0.0
public class SpitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpitApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
}
