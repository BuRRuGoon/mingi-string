package org.mingi.jdbc.chap04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mingi.jdbc.chap03.DuplicateMemberException;
import org.mingi.jdbc.chap03.Member;
import org.mingi.jdbc.chap03.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;

	static Logger logger = LogManager.getLogger();
	/**
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	*/
	
	public void regist(RegisterRequest req) throws DuplicateMemberException {
		logger.debug(req);
		Member member = memberDao.selectByEmail(req.getEmail());

		
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복" + req.getEmail());
		}

		
		Member newMember = new Member(req.getEmail(), req.getPassword(),
				req.getName());
		memberDao.insert(newMember);
		logger.debug("회원 정보를 저장했습니다.");
}
}
