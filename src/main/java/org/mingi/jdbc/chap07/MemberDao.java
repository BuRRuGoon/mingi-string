package org.mingi.jdbc.chap07;

import java.util.List;

import org.mingi.jdbc.chap03.Member;

public interface MemberDao {
	
	Member selectByEmail(String email);
	
	void insert(Member member);
	
	void update(Member member);
	
	List<Member> selectAll(int offset, int count);

}