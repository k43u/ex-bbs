package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.domain.Article;

/**
 *  articlesテーブルを操作するリポジトリです。
 * 
 * @author kashimamiyu
 *
 */

@Repository
public class ArticleRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	

	private static final RowMapper<Article> ARTICLE_ROW_MAPPER = (rs, i) -> {
		Article article = new Article();
		article.setId(rs.getInt("id"));
		article.setName(rs.getString("name"));
		article.setContent(rs.getString("content"));
		return article;
	};
	
	/**
	 * 全件検索
	 * 
	 * @return 記事一覧情報
	 */
	public List<Article> findAll() {
		String sql = "SELECT id,name,content FROM articles ORDER BY id DESC";

		List<Article> articleList = template.query(sql, ARTICLE_ROW_MAPPER);

		return articleList;
	}
	

	/**
	 * 記事情報を挿入する
	 * @param article 
	 */
	public void insert(Article article) {
		SqlParameterSource param
		 = new BeanPropertySqlParameterSource(article);
		
	    String insertSql
			 = "INSERT INTO articles(name,content) VALUES(:name,:content);";
	    
		template.update(insertSql, param);
	}
	
	/**
	 * 記事情報を削除する
	 * @param id
	 */
	public void deleteById(Integer id) {
		String sql = "DELETE FROM articles WHERE id=:id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		template.update(sql, param);
	}

	
}
