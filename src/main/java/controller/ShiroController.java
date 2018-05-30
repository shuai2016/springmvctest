package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("shiro")
public class ShiroController {
	@ResponseBody
	@RequestMapping(value = "note",produces = "application/json; charset=utf-8")
	public String note(){
		return "请登录";
	}

	@RequestMapping("login")
	public String login(){
		return "login";
	}

}
