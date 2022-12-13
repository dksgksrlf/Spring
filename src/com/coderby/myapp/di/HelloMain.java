package com.coderby.myapp.di;

public class HelloMain {
	//생성자를 이용한 의존성 주입
	public static void main(String[] args) {
		IHelloService helloService = new HelloService();
		HelloController controller = new HelloController(helloService);
		controller.hello("홍길동");
	}

}
