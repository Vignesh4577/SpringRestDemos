package com.example.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping("/greet/{username}")
	public String greet(HttpServletRequest request, @PathVariable("username") String username) {
		String message = (String) request.getAttribute("message");
		System.out.println(message);
		request.setAttribute("newmessage ", "Great Job" + username);
		return "Have a great day!!!!" + username;

	}
}
