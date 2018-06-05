package controller;

import controller.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import until.DB;
import until.User;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class UserController extends BaseController{
	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("login")
	public String login(){
		return "login";
	}

	@RequestMapping("validate")
	public String validate(HttpServletRequest request,ModelMap modelMap, String username, String password){

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
            User user = DB.findUserByUserName(username);
            request.getSession().setAttribute("currentUser",user);
			modelMap.put("message", "登录成功，当前用户："+token.getPrincipal());
		} catch (IncorrectCredentialsException e) {
			modelMap.put("message", "登录密码错误，当前用户："+token.getPrincipal());
		} catch (UnknownAccountException e) {
			modelMap.put("message", "帐号不存在，当前用户："+token.getPrincipal());
		}
		return "validate";
	}

	@ResponseBody
	@RequestMapping("getSession")
	public String getSession(){
	    User user = getCurrentUser();
	    if (user != null){
            return user.toString();
        } else {
	        return "-1";
        }
    }
}
