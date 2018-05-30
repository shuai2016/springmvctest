package controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping("shiro01")
	public void shiro01(HttpServletResponse response) throws IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		//读取文件中内容shiro.ini
		//之后几步就是流程
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
		subject.login(token);

		//获取当前登陆用户的用户名
		out.print("用户名为："+subject.getPrincipal()+"<br>");
		//判断是否有某个角色
		out.print("当前用户是否具有role1角色："+subject.hasRole("role1")+"<br>");
		out.print("当前用户是否具有role2角色："+subject.hasRole("role2")+"<br>");
		out.print("当前用户是否具有role3角色："+subject.hasRole("role3")+"<br>");
		//判断是否同时具有三个角色
		List<String> list = new ArrayList<String>();
		list.add("role1");
		list.add("role2");
		list.add("role3");
		out.print("当前用户是否同时具有role1，role2，role3角色："+subject.hasAllRoles(list)+"<br>");
		//判断是否有某些角色
		boolean[] array = subject.hasRoles(list);
		for (int i = 0; i < array.length; i++) {
			out.print(array[i]+"<br>");
		}
		//判断是否具有某个权限
		out.print("当前用户是否具有add1权限："+subject.isPermitted("add1")+"<br>");
		out.print("当前用户是否具有add2权限："+subject.isPermitted("add2")+"<br>");
		out.print("当前用户是否具有add3权限："+subject.isPermitted("add3")+"<br>");
	}

	@RequestMapping("shiro02")
	public void shiro02(){



	}

}
