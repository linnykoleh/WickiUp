package com.linnyk.wickiup.spring.metrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linnyk.wickiup.spring.metrics.services.MyLongService;

@RestController
@RequestMapping("/rest")
public class HelloController {

	@Autowired
	private MyLongService myLongService;


	@GetMapping("/hello")
	public String hello() throws InterruptedException {
		myLongService.doSomeLongRequest();
		return "Hello Youtube";
	}

	@GetMapping("/hello2")
	public String hello2() {
		return "Hello Youtube";
	}

	@GetMapping("/hello3")
	public String hello3() {
		return "Hello Youtube";
	}

	@GetMapping("/hello4")
	public String hello4() {
		return "Hello Youtube";
	}

	@RequestMapping("/fast")
	public String fast() throws InterruptedException {
		long cur = System.currentTimeMillis();
		Thread.sleep(1000);
		return "home";
	}
}