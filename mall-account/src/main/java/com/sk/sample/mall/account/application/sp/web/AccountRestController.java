package com.sk.sample.mall.account.application.sp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountRestController {
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	//loginForm
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void loginPOST(String id) {
		System.out.println("Submit ID :: " + id);
	}
}
