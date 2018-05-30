package until;

import java.util.*;

public class DB {
	private static List<User> userList = new ArrayList<User>();
	private static List<Role> roleList = new ArrayList<Role>();
	private static List<Permission> permissionList = new ArrayList<Permission>();
	private static Map<String,String[]> userRole = new HashMap<String,String[]>();
	private static Map<String,String[]> rolePermission = new HashMap<String,String[]>();
	static {
		//设置用户
		userList.add(new User("1","zhangsan","123"));
		userList.add(new User("2","lisi","456"));
		//设置角色
		roleList.add(new Role("1","role1"));
		roleList.add(new Role("2","role2"));
		roleList.add(new Role("3","role3"));
		//设置权限
		permissionList.add(new Permission("1","add1"));
		permissionList.add(new Permission("2","delete1"));
		permissionList.add(new Permission("3","add2"));
		permissionList.add(new Permission("4","delete2"));
		permissionList.add(new Permission("5","add3"));
		permissionList.add(new Permission("6","delete3"));
		//设置关联
		userRole.put("1",new String[]{"1","2"});
		userRole.put("2",new String[]{"2","3"});
		rolePermission.put("1",new String[]{"1","2"});
		rolePermission.put("2",new String[]{"3","4"});
		rolePermission.put("3",new String[]{"5","6"});

	}

	public static User findUserByUserName(String username){
		for (User user : userList) {
			if(user.getUsername().equals(username)){
				return user ;
			}
		}
		return null;
	}

	public static List<Role> findRoleListByUserId(String userId){
		List<Role> list = new ArrayList<Role>();
		String[] roleIds = userRole.get(userId);
		for (String roleId : roleIds) {
			for (Role role : roleList) {
				if(role.getId().equals(roleId)){
					list.add(role);
				}
			}
		}
		return list;
	}

	public static List<Permission> findPermissionListByRoleId(String roleId){
		List<Permission> list = new ArrayList<Permission>();
		String[] permissionIds = rolePermission.get(roleId);
		for (String permissionId : permissionIds) {
			for (Permission permission : permissionList) {
				if(permission.getId().equals(permissionId)){
					list.add(permission);
				}
			}
		}
		return list;
	}




}
