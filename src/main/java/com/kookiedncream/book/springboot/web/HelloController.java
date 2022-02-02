package com.kookiedncream.book.springboot.web;

import com.kookiedncream.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(@ModelAttribute HelloResponseDto dto) {
		return dto;
	}
}
