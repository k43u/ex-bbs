package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.domain.Comment;

/**
 * commentsテーブルを操作するリポジトリです。
 * 
 * @author kashimamiyu
 *
 */
@Repository
public class CommentRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("article_id"));
		return comment;
	};

	/**
	 * 投稿ごとのコメントを表示
	 * 
	 * @param articleId
	 * @return 投稿ごとのコメントの情報
	 */
	public List<Comment> findByArticleId(Integer articleId) {
		String sql = "SELECT id,name,content,article_id FROM comments WHERE article_id = :articleId ORDER BY id DESC";

		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);

		List<Comment> commentList = template.query(sql, param, COMMENT_ROW_MAPPER);

		return commentList;
	}

	/**
	 * コメントを挿入する
	 * 
	 * @param article
	 */
	public void insert(Comment comment) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);

		String insertSql = "INSERT INTO comments(name,content,article_id) VALUES(:name,:content,:articleId);";

		template.update(insertSql, param);
	}

	/**
	 * コメントを削除する
	 * 
	 * @param articleId
	 */
	public void deleteByArticleId(Integer articleId) {
		String sql = "DELETE FROM comments WHERE article_id = :articleId";

		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);

		template.update(sql, param);
	}

}
