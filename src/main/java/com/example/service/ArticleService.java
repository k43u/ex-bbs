package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.domain.Article;
import com.example.repository.ArticleRepository;

/**
 * 記事の情報を表示する業務処理を行います。
 * 
 * @author kashimamiyu
 *
 */
@Service
@Transactional
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	
	/**
	 * 記事の情報の全件取得
	 * 
	 * @return　記事情報全件
	 */
	public List<Article> showList(){
		return articleRepository.findAll();
	}
	
	/**
	 * 記事情報を挿入する。
	 * 
	 * @param article
	 */
	public void insert(Article article) {
		articleRepository.insert(article);
	}

}
