package com.lovo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义授权Realm类
 * 
 * @author Administrator
 * 
 */
public class MyAuthorizingRealm extends AuthorizingRealm {
	// 添加用户权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO 自动生成的方法存根
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRole("admin");

		authorizationInfo.addObjectPermission(new WildcardPermission(
				"user:update"));
		authorizationInfo.addStringPermission("user:view");
		authorizationInfo.addStringPermission("user:delete");
		authorizationInfo.addStringPermission("user:create");
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO 自动生成的方法存根
		// 获取用户名
		String username = (String) token.getPrincipal();

		String password = new String((char[]) token.getCredentials());

		// 验证用户名
		if (!"lovo".equals(username)) {
			throw new UnknownAccountException();
		}
		if (!"12345".equals(password)) {
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username, password, getName());
	}

}
