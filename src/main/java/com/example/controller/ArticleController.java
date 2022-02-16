package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.domain.Article;
import com.example.form.ArticleForm;
import com.example.service.ArticleService;

/**
 * 記事を表示する処理を行います。
 * 
 * @author kashimamiyu
 *
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	/**
	 * @return ArticleFormをインスタンス化
	 */
	@ModelAttribute
	public ArticleForm setUpArticleForm(){
		return new ArticleForm();
	}
	
	/**
	 * 記事の一覧を取得
	 * @param model
	 * @return 掲示板
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("articleList", articleService.showList());
		return "board";
	}
	
	/**
	 * 記事の情報を登録する。
	 * @param articleForm
	 * @return 掲示板
	 */
	@RequestMapping("/insertArticle")
	public String insertArticle(ArticleForm articleForm, Model model ) {
		Article article = new Article();
		article.setName(articleForm.getName());
		article.setContent(articleForm.getContent());
		articleService.insert(article);
		model.addAttribute("articleList", articleService.showList());
		return "board";
	}
		
}
