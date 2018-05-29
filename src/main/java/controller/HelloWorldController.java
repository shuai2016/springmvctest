package controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

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

	@RequestMapping("shiro01")
	public void shiro01(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.write("<h1>Hello World !</h1>");
	}
}
