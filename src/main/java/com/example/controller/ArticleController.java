package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.form.ArticleForm;
import com.example.form.CommentForm;
import com.example.service.ArticleService;
import com.example.service.CommentService;

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
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * @return ArticleFormをインスタンス化
	 */
	@ModelAttribute
	public ArticleForm setUpArticleForm(){
		return new ArticleForm();
	}
	
	@ModelAttribute
	public CommentForm setUpCommentForm(){
		return new CommentForm();
	}
	
	/**
	 * 記事とコメントの一覧を取得
	 * @param model
	 * @return 掲示板
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		List<Article> articleList = articleService.showList();
		for(Article article : articleList) {
		List<Comment> commentList =	commentService.findByArticleId(article.getId());
		article.setCommentList(commentList); 	
		}
		model.addAttribute("articleList", articleList);
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
		List<Article> articleList = articleService.showList();
		for(Article article1 : articleList) {
		List<Comment> commentList =	commentService.findByArticleId(article1.getId());
		article1.setCommentList(commentList); 	
		}
		model.addAttribute("articleList", articleList);
		return "board";
	}
	
	/**
	 * コメントの情報を登録する。
	 * @param commentForm
	 * @return 掲示板
	 */
	@RequestMapping("/insertComment")
	public String insertComment(CommentForm commentForm, Model model ) {
		System.out.println(commentForm);
		Comment comment = new Comment();
		comment.setName(commentForm.getName());
		comment.setContent(commentForm.getContent());
		comment.setArticleId(Integer.parseInt(commentForm.getArticleId()));
		commentService.insert(comment);
		List<Article> articleList = articleService.showList();
		for(Article article : articleList) {
		List<Comment> commentList =	commentService.findByArticleId(article.getId());
		article.setCommentList(commentList); 	
		}
		model.addAttribute("articleList", articleList);
		return "board";
	}
	
	@RequestMapping("/deleteArticle")
	public String deleteArticle(Model model) {
		Article article = new Article();
		articleService.deleteById(article.getId());
		commentService.deleteByArticleId(article.getId());
		return "board";
	}
	
}
