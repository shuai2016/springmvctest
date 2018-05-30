package shiro;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import until.DB;
import until.Permission;
import until.Role;
import until.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm1 extends AuthorizingRealm {
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取传过来的用户名
		String username = (String)token.getPrincipal();
		//判断该用户是否存在
		User user = DB.findUserByUserName(username);
		if(user == null){
			throw new UnknownAccountException("用户名不存在") ;
		} else {
			//该用户存在
			//判断该用户是否存在密码
			String userPassword = user.getPassword();
			if(userPassword == null){
				return new SimpleAuthenticationInfo(username,null,"testRealm");
			} else {
				//该用户存在密码
				//获取穿过来的密码
				String password = new String((char[])token.getCredentials());
				if(!userPassword.equals(password)){
					throw new IncorrectCredentialsException("密码错误") ;
				}
				return new SimpleAuthenticationInfo(username,password,"testRealm");
			}
		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//此时说明用户已经登录成功了（上面方法验证成功后才会进入此方法），此方法用来加载用户的角色和权限
		//用来携带角色，权限
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		//存角色
		Set<String> roles = new HashSet<String>();
		//存权限
		Set<String> stringPermissions = new HashSet<>();
		//获取当前登录用户的用户名
		String username = (String)principalCollection.getPrimaryPrincipal();
		//获取用户
		User user = DB.findUserByUserName(username);
		//获取角色
		List<Role> roleList = DB.findRoleListByUserId(user.getId());
		for (Role role : roleList) {
			roles.add(role.getName());
			//获取权限
			List<Permission> permissionList = DB.findPermissionListByRoleId(role.getId());
			for (Permission permission : permissionList) {
				stringPermissions.add(permission.getName());
			}
		}
		auth.setRoles(roles);
		auth.setStringPermissions(stringPermissions);
		return auth;
	}
}
