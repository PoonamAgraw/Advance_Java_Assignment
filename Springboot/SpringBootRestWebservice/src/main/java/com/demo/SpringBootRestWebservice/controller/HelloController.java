package com.demo.SpringBootRestWebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String SayHello() {
		return "Hello world!";
	}

}
