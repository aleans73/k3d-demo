package com.example.spring.k3d.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GreeterController {

	@Autowired
	private GreeterConfig config;

	@GetMapping("/greet/{user}")
	public String greet(@PathVariable("user") String user) {
		String prefix = config.getPrefix();
		String from = config.getFrom();
		log.info("Prefix :{} and User:{} and From:{}", prefix, from);

		return prefix + " " + user + " " + from;
	}
}
