package com.study.dataanalisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.study.dataanalisys.process.ProcessFile;

@SpringBootApplication
@EnableScheduling
public class DataAnalisysApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAnalisysApplication.class, args);
		
		
		new ProcessFile();
	}

	@Scheduled(cron = "*/20 * * * * *")
	public static void eventListener() {

	}

}
