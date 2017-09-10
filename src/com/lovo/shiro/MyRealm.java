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
 * �Զ���Realm��
 * @author Administrator
 *
 */
public class MyRealm implements Realm{

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		//��ȡ�û���
		String username = (String) token.getPrincipal();
		
		String password = new String ((char[])token.getCredentials());
		
		//��֤�û���
		if(!"lovo".equals(username)){
			throw new UnknownAccountException(); 
		}
		if(!"12345".equals(password)){
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username,password,getName());
	}

	public String getName() {
		// TODO �Զ����ɵķ������
		return "myRealm";
	}

	public boolean supports(AuthenticationToken token) {
		//��֧��UsernamePasswordToken���͵�Token
		return token instanceof UsernamePasswordToken;
	}
	
}
