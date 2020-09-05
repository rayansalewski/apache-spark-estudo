package com.study.dataanalisys.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {
	public SparkConfig() {
		System.setProperty("hadoop.home.dir", "C://winutils");
	}
}
