package com.lovo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * 自定义Realm类
 * @author Administrator
 *
 */
public class MyRealm implements Realm{

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		//获取用户名
		String username = (String) token.getPrincipal();
		
		String password = new String ((char[])token.getCredentials());
		
		//验证用户名
		if(!"lovo".equals(username)){
			throw new UnknownAccountException(); 
		}
		if(!"12345".equals(password)){
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username,password,getName());
	}

	public String getName() {
		// TODO 自动生成的方法存根
		return "myRealm";
	}

	public boolean supports(AuthenticationToken token) {
		//仅支持UsernamePasswordToken类型的Token
		return token instanceof UsernamePasswordToken;
	}
	
}
