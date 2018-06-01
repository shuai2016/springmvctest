package controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class UserController {
	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("login")
	public String login(HttpServletRequest request,ModelMap modelMap){
		String base = request.getContextPath();
		modelMap.put("base",base);
		return "login";
	}

	@RequestMapping("validate")
	public String validate(HttpServletRequest request, ModelMap modelMap, String username, String password){

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
			modelMap.put("message", "登录成功，当前用户："+token.getPrincipal());
		} catch (IncorrectCredentialsException e) {
			modelMap.put("message", "登录密码错误，当前用户："+token.getPrincipal());
		} catch (UnknownAccountException e) {
			modelMap.put("message", "帐号不存在，当前用户："+token.getPrincipal());
		}
		//如果是因为访问其他路径儿跳转到登录页面，savedRequest将有值即想要访问的页面
		SavedRequest savedRequest = WebUtils.getSavedRequest(request);
		if(savedRequest !=null){
			String requestUrl = savedRequest.getRequestUrl();
			System.out.println(requestUrl);
		}
		return "validate";
	}

	@RequestMapping("message")
	public String message(){
		return "message";
	}
}
