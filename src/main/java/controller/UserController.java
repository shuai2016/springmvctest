package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class UserController {
	@RequestMapping("login")
	public String hello() {
		return "hello" ;
	}
}
