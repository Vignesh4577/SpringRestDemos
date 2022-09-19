package com.productapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.AppUser;
import com.productapp.service.AppUserServiceImpl;

@RestController
public class AppUserController {

	@Autowired
	AppUserServiceImpl appUserServiceImpl;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/")
	public String addUser(@RequestBody AppUser appUser) {

		//get the password from the appuser
		String password = appUser.getPassword();
		//encode the password
		String newpassword = passwordEncoder.encode(password);
		//set the password tothe appuser object
		appUser.setPassword(newpassword);

		appUserServiceImpl.addUser(appUser);

		return "added";
	}
}
