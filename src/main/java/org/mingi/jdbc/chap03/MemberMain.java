package org.mingi.jdbc.chap03;

public class MemberMain {
	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		MemberRegisterService regService = new MemberRegisterService(memberDao);

		RegisterRequest req = new RegisterRequest();
		req.setEmail("alsrl7503@naver.co");
		req.setPassword("7503");
		req.setName("BuRRu");

		regService.regist(req);
}
}
