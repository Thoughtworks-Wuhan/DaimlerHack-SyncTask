package com.daimler;

import com.daimler.aync.configuration.TaskThreadPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication

@EnableAsync
@EnableConfigurationProperties({TaskThreadPoolConfig.class})
public class HackApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackApplication.class, args);
	}
}
