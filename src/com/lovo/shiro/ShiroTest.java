package com.lovo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Shiro��ȫ��ܲ���
 * 
 * @author Administrator
 * 
 */
public class ShiroTest {
	// ���������֤��ini�����ļ���
	public void AuthenticationTest() {
		// ����SecurityManager������ʹ��ini�����ļ���ʼ����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:IniRealm.ini");
		// ��ȡSecurityManager����ʵ��
		SecurityManager securityManager = factory.getInstance();

		// ��SecurityManagerʵ����ʼ��SecurityUtils������
		SecurityUtils.setSecurityManager(securityManager);

		// �����û��������������֤Token���ƶ���
		UsernamePasswordToken token = new UsernamePasswordToken("lovo",
				"123456");

		// ��ȡSubject�������
		Subject currentUser = SecurityUtils.getSubject();

		// �����֤
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println("�û������֤ʧ��");
		}
		// �ж������֤
		boolean result = currentUser.isAuthenticated();
		if (result) {
			System.out.println("�û������֤�ɹ�");
		} else {
			System.out.println("�û������֤ʧ��");
		}
		// �ж��û���ɫ���ֿ�����Ȩ�ޣ�
		if (currentUser.hasRole("admin")) {
			System.out.println("�û���ɫΪ����Ա");
		} else {
			System.out.println("�û���ɫ���ǹ���Ա");
		}
		// �ж��û�Ȩ�ޣ�ϸ������Ȩ�ޣ�
		if (currentUser.isPermittedAll()) {
			System.out.println("����Ա�����в�����ԴȨ��");
		} else {
			System.out.println("����Ա�����в�����ԴȨ��");
		}

		// �˳�
		currentUser.logout();
	}

	// ���������֤���Զ��壩
	public void AuthenticationTest2() {
		// ����SecurityManager������ʹ��ini�����ļ���ʼ����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:MyRealm.ini");
		// ��ȡSecurityManager����ʵ��
		SecurityManager securityManager = factory.getInstance();

		// ��SecurityManagerʵ����ʼ��SecurityUtils������
		SecurityUtils.setSecurityManager(securityManager);

		// �����û��������������֤Token���ƶ���
		UsernamePasswordToken token = new UsernamePasswordToken("lovo",
				"123456");

		// ��ȡSubject�������
		Subject currentUser = SecurityUtils.getSubject();

		// �����֤
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println("�û������֤ʧ��");
		}
		// �ж������֤
		boolean result = currentUser.isAuthenticated();
		if (result) {
			System.out.println("�û������֤�ɹ�");
		} else {
			System.out.println("�û������֤ʧ��");
		}
		// �˳�
		currentUser.logout();
	}

	// ���������֤�����Դ���
	public void AuthenticationTest3() {
		// ����SecurityManager������ʹ��ini�����ļ���ʼ����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:JdbcRealm.ini");
		// ��ȡSecurityManager����ʵ��
		SecurityManager securityManager = factory.getInstance();

		// ��SecurityManagerʵ����ʼ��SecurityUtils������
		SecurityUtils.setSecurityManager(securityManager);

		// �����û��������������֤Token���ƶ���
		UsernamePasswordToken token = new UsernamePasswordToken("lovo",
				"123456");

		// ��ȡSubject�������
		Subject currentUser = SecurityUtils.getSubject();

		// �����֤
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println("�û������֤ʧ��");
		}
		// �ж������֤
		boolean result = currentUser.isAuthenticated();
		if (result) {
			System.out.println("�û������֤�ɹ�");
		} else {
			System.out.println("�û������֤ʧ��");
		}
		// �˳�
		currentUser.logout();
	}

	// ���������֤���Զ��壩
	public void AuthorizationTest2() {
		// ����SecurityManager������ʹ��ini�����ļ���ʼ����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:MyAuthorizingRealm.ini");
		// ��ȡSecurityManager����ʵ��
		SecurityManager securityManager = factory.getInstance();

		// ��SecurityManagerʵ����ʼ��SecurityUtils������
		SecurityUtils.setSecurityManager(securityManager);

		// �����û��������������֤Token���ƶ���
		UsernamePasswordToken token = new UsernamePasswordToken("lovo",
				"123456");

		// ��ȡSubject�������
		Subject currentUser = SecurityUtils.getSubject();

		// �����֤
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println("�û������֤ʧ��");
		}
		// �ж������֤
		boolean result = currentUser.isAuthenticated();
		if (result) {
			System.out.println("�û������֤�ɹ�");
		} else {
			System.out.println("�û������֤ʧ��");
		}
		// �ж��û���ɫ���ֿ�����Ȩ�ޣ�
		if (currentUser.hasRole("admin")) {
			System.out.println("�û���ɫΪ����Ա");
		} else {
			System.out.println("�û���ɫ���ǹ���Ա");
		}
		// �ж��û�Ȩ�ޣ�ϸ������Ȩ�ޣ�
		if (currentUser.isPermittedAll()) {
			System.out.println("����Ա�����в�����ԴȨ��");
		} else {
			System.out.println("����Ա�����в�����ԴȨ��");
		}
		// �˳�
		currentUser.logout();
	}

	// ������Ȩ(JDBC)
	public void AuthorizationTest3() {
		// ����SecurityManager������ʹ��ini�����ļ���ʼ����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:JdbcRealm.ini");
		// ��ȡSecurityManager����ʵ��
		SecurityManager securityManager = factory.getInstance();

		// ��SecurityManagerʵ����ʼ��SecurityUtils������
		SecurityUtils.setSecurityManager(securityManager);

		// �����û��������������֤Token���ƶ���
		UsernamePasswordToken token = new UsernamePasswordToken("lovo",
				"123456");

		// ��ȡSubject�������
		Subject currentUser = SecurityUtils.getSubject();

		// �����֤
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println("�û������֤ʧ��");
		}
		// �ж������֤
		boolean result = currentUser.isAuthenticated();
		if (result) {
			System.out.println("�û������֤�ɹ�");
		} else {
			System.out.println("�û������֤ʧ��");
		}
		// �ж��û���ɫ���ֿ�����Ȩ�ޣ�
		if (currentUser.hasRole("admin")) {
			System.out.println("�û���ɫΪ����Ա");
		} else {
			System.out.println("�û���ɫ���ǹ���Ա");
		}
		// �˳�
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
