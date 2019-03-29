package org.mingi.jdbc.chap03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMainUsingSpring {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("chap03.xml");
		MemberRegisterService regService = ctx.getBean("memberRegisterService",MemberRegisterService.class);
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail("alsrl7503@naver.com");
		req.setPassword("7503");
		req.setName("BuRRu");
		
		regService.regist(req);
	}
}
