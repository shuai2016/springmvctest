package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	public HelloWorldController() {
		System.out.println("HelloWorldController扫描到了！！！");
	}

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!!!";
	}

	@ResponseBody
	@RequestMapping("mypc")
	public String mypc(){
		return "自己电脑测试";
	}
}
