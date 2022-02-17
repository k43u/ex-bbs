package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.domain.Comment;
import com.example.repository.CommentRepository;

/**
 * コメントの情報を表示する業務処理を行います。
 * 
 * @author kashimamiyu
 *
 */
@Service
@Transactional
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	/**
	 * 記事IDごとのコメントの取得
	 * 
	 * @return 記事IDごとのコメント情報
	 */
	public List<Comment> findByArticleId(Integer articleId){
		return commentRepository.findByArticleId(articleId);
	}
	
	/**
	 * コメント情報を挿入する。
	 * 
	 * @param comment
	 */
	public void insert(Comment comment) {
		commentRepository.insert(comment);
	}
	
	/**
	 * コメント情報を削除する。
	 * 
	 * @param articleId
	 */
	public void deleteByArticleId(int articleId) {
		commentRepository.deleteByArticleId(articleId);
	}
}
