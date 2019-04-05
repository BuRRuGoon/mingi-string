package org.mingi.jdbc.chap04;

import org.mingi.jdbc.chap03.RegisterRequest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMainUsingComponentScan {
		public static void main(String[] args) {
			ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("chap04.xml");
			MemberRegisterService regService = ctx.getBean("memberRegisterService",MemberRegisterService.class);
			
			RegisterRequest req = new RegisterRequest();
			req.setEmail("alsrl7503@naver.com");
			req.setPassword("7503");
			req.setName("BuRRu");
			
			regService.regist(req);
			ctx.close();
		}
	}
