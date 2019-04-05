package org.mingi.jdbc.chap08;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberMain {
	public static void main(String[] args) throws Exception {
		new MemberMain().go();
	}
	
	public void go() throws Exception{
		Properties props = new Properties();
		
		InputStream in = getClass().getClassLoader()
				.getResourceAsStream("db.properties");
		props.load(in);
		
		DataSource dataSource = new MariaDbDataSource(props.getProperty("db.url"));
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		MemberDaoImplUsingSpringJdbc memberDao = new MemberDaoImplUsingSpringJdbc();
		memberDao.setJdbcTemplate(jdbcTemplate);
		
		MemberService memberService = new MemberService();
		memberService.setMemberDao(memberDao);
		
		memberService.insertMember();
		memberService.selectAll();
	}
	}
