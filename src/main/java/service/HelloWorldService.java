package service;

import org.springframework.stereotype.Service;

@Service("HelloWorldService")
public class HelloWorldService {
	public HelloWorldService() {
		System.out.println("HelloWorldService扫描到了！！！");
	}
}