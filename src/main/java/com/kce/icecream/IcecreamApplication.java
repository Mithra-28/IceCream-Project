package com.kce.icecream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class IcecreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcecreamApplication.class, args);
	}

}
