package com.xyc.learn.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaServer
public class EkServerApplication {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String profiles = scan.nextLine();
//		// SpringApplication.run(EkServerApplication.class, args);
//		new SpringApplicationBuilder(EkServerApplication.class)
//				.profiles(profiles).run(args);
		SpringApplication.run(EkServerApplication.class, args);
	}

}
