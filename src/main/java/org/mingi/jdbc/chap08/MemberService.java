package org.mingi.jdbc.chap08;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mingi.jdbc.chap03.Member;

public class MemberService {
	Logger logger = LogManager.getLogger();
	
	MemberDao memberDao = null;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
}
	
	public void selectAll() {
		List<Member> members = memberDao.selectAll(0, 100);
		logger.debug(members);
	}
	
	public void updateMember() {
		Member member = memberDao.selectByEmail("alsrl7503@naver.com");
		member.setPassword("7503");
		memberDao.update(member);
		logger.debug("Udate complate.");
	}
	
	public void insertMember() {
		Member member = new Member();
		member.setEmail("alsrl7503@naver.com");
		member.setPassword("7503");
		member.setName("한민기");
		memberDao.insert(member);
		logger.debug("Insert complate");
	}
}
