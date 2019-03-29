package org.mingi.jdbc.chap03EX;

public class ArticleService {
		MemberDao memberDao;
		
		public void setMemberDao(MemberDao memberDao) {
			this.memberDao = memberDao;
		}
		
		public void addArticle() {
			memberDao.getMember();
		}
}
