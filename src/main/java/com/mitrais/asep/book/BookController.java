package com.mitrais.asep.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookController {
	public static void main(String[] args) {
		SpringApplication.run(BookController.class, args);
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello";
	}
}

