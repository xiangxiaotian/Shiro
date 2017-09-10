package com.lovo.shiro;

import java.util.Arrays;
import java.util.Collection;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * �Զ����ɫȨ����
 * @author Administrator
 *
 */
public class MyRolePermissionResolver implements RolePermissionResolver{

	public Collection<Permission> resolvePermissionsInRole(String role) {
		if("admin".equals(role)){
			return Arrays.asList((Permission)new WildcardPermission("menu:*"));
		}
		
		return null;
	}

}
