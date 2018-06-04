package controller;

import org.apache.shiro.session.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	public HelloWorldController() {
		System.out.println("HelloWorldController扫描到了！！！");
	}

	@ResponseBody
	@RequestMapping("hello")
	public String hello() {
		return "Hello World!!!";
	}

	@RequestMapping("list")
	public String list(){
	    return "list";
    }

}
