package com.dagim.restfulWs.RestfulwsSpringBoot.helloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@RequestMapping(path="/helloWorld", method=RequestMethod.GET)
	public String helloWorld(){
		return "Hello WOrld From Spring Boot";
	}
	
	@RequestMapping(path="/helloWorld-Bean", method=RequestMethod.GET)
	public HelloWorldBean herlloWorldBean(){
		return new HelloWorldBean("Hello-World From Bean!");
	}

}
