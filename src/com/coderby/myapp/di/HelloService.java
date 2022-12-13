package com.coderby.myapp.di;

public class HelloService implements IHelloService{
	@Override
	public String sayHello(String name) {
		System.out.println("HelloService.sayHello() 메소드 실행");
		String message = "Hello~~~"+name;
		return message;
	}
}
