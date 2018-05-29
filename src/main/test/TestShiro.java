import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestShiro {

	@Test
	public void test() {
		System.out.println("Hello World !");
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("admin2","hello2");
		subject.login(token);
		System.out.println(subject.getPrincipal());
		System.out.println("角色验证1=========");
		System.out.println(subject.hasRole("role2"));
		List<String> list = new ArrayList<String>();
		list.add("role1");
		list.add("role2");
		System.out.println("角色验证2=========");
		System.out.println(subject.hasAllRoles(list));
		System.out.println("角色验证3=========");
		boolean[]  array = subject.hasRoles(list);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println("=================");
		System.out.println("权限验证1=========");
		System.out.println(subject.isPermitted("add2"));
	}
}
