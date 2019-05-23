package com.sk.sample.mall.account.application.sp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/account/*")
public class AccountRestController {
//	@RequestMapping(method=RequestMethod.GET)
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
//	@RequestMapping(method=RequestMethod.GET)
	@GetMapping("account")
	public String account() {
		return "account";
	}
}
