package com.example.spring.k3d.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "greeting")
@Data
public class GreeterConfig {
  
	private String prefix;
	private String from;
	
}
