package com.EricHsu.springbootmall;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	@RequestMapping("/")
	public String hello(){
		return "Hey, Spring Boot 的 Hello World ! ";
	}
}
