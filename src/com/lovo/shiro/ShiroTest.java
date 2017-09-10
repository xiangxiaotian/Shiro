package com.lovo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Shiro安全框架测试
 * 
 * @author Administrator
 * 
 */
public class ShiroTest {
	// 测试身份验证（ini配置文件）
	public void AuthenticationTest() {
		// 创建SecurityManager工厂（使用ini配置文件初始化）
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:IniRealm.ini");
		// 获取SecurityManager对象实例
		SecurityManager securityManager = factory.getInstance();

		// 绑定SecurityManager实例初始化SecurityUtils工具类
		SecurityUtils.setSecurityManager(securityManager);

		// 创建用户名、密码身份验证Token令牌对象
		UsernamePasswordToken token = new UsernamePasswordToken("lovo",
				"123456");

		// 获取Subject主体对象
		Subject currentUser = SecurityUtils.getSubject();

		// 身份验证
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println("用户身份验证失败");
		}
		// 判断身份验证
		boolean result = currentUser.isAuthenticated();
		if (result) {
			System.out.println("用户身份验证成功");
		} else {
			System.out.println("用户身份验证失败");
		}
		// 判断用户角色（粗颗粒度权限）
		if (currentUser.hasRole("admin")) {
			System.out.println("用户角色为管理员");
		} else {
			System.out.println("用户角色不是管理员");
		}
		// 判断用户权限（细颗粒度权限）
		if (currentUser.isPermittedAll()) {
			System.out.println("管理员有所有操作资源权限");
		} else {
			System.out.println("管理员无所有操作资源权限");
		}

		// 退出
		currentUser.logout();
	}

	// 测试身份验证（自定义）
	public void AuthenticationTest2() {
		// 创建SecurityManager工厂（使用ini配置文件初始化）
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:MyRealm.ini");
		// 获取SecurityManager对象实例
		SecurityManager securityManager = factory.getInstance();

		// 绑定SecurityManager实例初始化SecurityUtils工具类
		SecurityUtils.setSecurityManager(securityManager);

		// 创建用户名、密码身份验证Token令牌对象
		UsernamePasswordToken token = new UsernamePasswordToken("lovo",
				"123456");

		// 获取Subject主体对象
		Subject currentUser = SecurityUtils.getSubject();

		// 身份验证
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println("用户身份验证失败");
		}
		// 判断身份验证
		boolean result = currentUser.isAuthenticated();
		if (result) {
			System.out.println("用户身份验证成功");
		} else {
			System.out.println("用户身份验证失败");
		}
		// 退出
		currentUser.logout();
	}

	// 测试身份验证（能自带）
	public void AuthenticationTest3() {
		// 创建SecurityManager工厂（使用ini配置文件初始化）
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:JdbcRealm.ini");
		// 获取SecurityManager对象实例
		SecurityManager securityManager = factory.getInstance();

		// 绑定SecurityManager实例初始化SecurityUtils工具类
		SecurityUtils.setSecurityManager(securityManager);

		// 创建用户名、密码身份验证Token令牌对象
		UsernamePasswordToken token = new UsernamePasswordToken("lovo",
				"123456");

		// 获取Subject主体对象
		Subject currentUser = SecurityUtils.getSubject();

		// 身份验证
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println("用户身份验证失败");
		}
		// 判断身份验证
		boolean result = currentUser.isAuthenticated();
		if (result) {
			System.out.println("用户身份验证成功");
		} else {
			System.out.println("用户身份验证失败");
		}
		// 退出
		currentUser.logout();
	}

	// 测试身份验证（自定义）
	public void AuthorizationTest2() {
		// 创建SecurityManager工厂（使用ini配置文件初始化）
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:MyAuthorizingRealm.ini");
		// 获取SecurityManager对象实例
		SecurityManager securityManager = factory.getInstance();

		// 绑定SecurityManager实例初始化SecurityUtils工具类
		SecurityUtils.setSecurityManager(securityManager);

		// 创建用户名、密码身份验证Token令牌对象
		UsernamePasswordToken token = new UsernamePasswordToken("lovo",
				"123456");

		// 获取Subject主体对象
		Subject currentUser = SecurityUtils.getSubject();

		// 身份验证
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println("用户身份验证失败");
		}
		// 判断身份验证
		boolean result = currentUser.isAuthenticated();
		if (result) {
			System.out.println("用户身份验证成功");
		} else {
			System.out.println("用户身份验证失败");
		}
		// 判断用户角色（粗颗粒度权限）
		if (currentUser.hasRole("admin")) {
			System.out.println("用户角色为管理员");
		} else {
			System.out.println("用户角色不是管理员");
		}
		// 判断用户权限（细颗粒度权限）
		if (currentUser.isPermittedAll()) {
			System.out.println("管理员有所有操作资源权限");
		} else {
			System.out.println("管理员无所有操作资源权限");
		}
		// 退出
		currentUser.logout();
	}

	// 测试授权(JDBC)
	public void AuthorizationTest3() {
		// 创建SecurityManager工厂（使用ini配置文件初始化）
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:JdbcRealm.ini");
		// 获取SecurityManager对象实例
		SecurityManager securityManager = factory.getInstance();

		// 绑定SecurityManager实例初始化SecurityUtils工具类
		SecurityUtils.setSecurityManager(securityManager);

		// 创建用户名、密码身份验证Token令牌对象
		UsernamePasswordToken token = new UsernamePasswordToken("lovo",
				"123456");

		// 获取Subject主体对象
		Subject currentUser = SecurityUtils.getSubject();

		// 身份验证
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println("用户身份验证失败");
		}
		// 判断身份验证
		boolean result = currentUser.isAuthenticated();
		if (result) {
			System.out.println("用户身份验证成功");
		} else {
			System.out.println("用户身份验证失败");
		}
		// 判断用户角色（粗颗粒度权限）
		if (currentUser.hasRole("admin")) {
			System.out.println("用户角色为管理员");
		} else {
			System.out.println("用户角色不是管理员");
		}
		// 退出
		currentUser.logout();
	}

	public static void main(String[] args) {
		ShiroTest test = new ShiroTest();
		// test.AuthenticationTest();
		// test.AuthenticationTest2();
		// test.AuthenticationTest3();
		test.AuthorizationTest2();
//		test.AuthorizationTest3();

	}
}
