package com.xyc.learn.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EkProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkProviderApplication.class, args);
	}

}
