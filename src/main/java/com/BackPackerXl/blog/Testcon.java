package com.BackPackerXl.blog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcon {
	@RequestMapping("/hello")
public String hello() {
	return "helloworld,this is my blog!";
}
	int a=4,b=6;
	@RequestMapping("/sum")
	public int sum() {
		return (a+b);
	}

}