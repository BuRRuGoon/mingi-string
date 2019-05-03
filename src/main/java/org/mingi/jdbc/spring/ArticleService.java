package org.mingi.jdbc.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	
	@Autowired
	ArticleDao articleDao;

	/**
	 * 글 목록
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	/**
	 * 글 조회
	 */
	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}
	public void addArticle() {
		Article article = new Article();
		article.setTitle("화웨이 CEO '삼성, 화웨이 폴더블폰 모방에 1년 걸릴것'");
		article.setContent("업계에선 인폴딩 방식이 아웃폴딩보다 개발하기가 더 어렵다는 반응이다");
		article.setUserId("4");
		article.setName("한민기");
		if (articleDao.addArticle(article) > 0)
			System.out.println("글을 추가했습니다.");
		else
			System.out.println("글을 추가하지 못했습니다.");
	}
	
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("7");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("글을 수정했습니다.");
		else
			System.out.println("글을 수정하지 못했습니다.");
	}
	public void deleteArticle() {
		if (articleDao.deleteArticle("8") > 0)
			System.out.println("글을 삭제했습니다.");
		else
			System.out.println("글을 삭제하지 못했습니다.");
	}
}
