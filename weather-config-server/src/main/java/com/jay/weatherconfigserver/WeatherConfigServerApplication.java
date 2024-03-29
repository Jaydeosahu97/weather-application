package com.jay.weatherconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class WeatherConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherConfigServerApplication.class, args);
	}

}
