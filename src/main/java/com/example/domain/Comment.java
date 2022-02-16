package com.example.domain;

/**
 * コメントを表すリポジトリです。
 * 
 * @author kashimamiyu
 *
 */
public class Comment {

	/**ID*/
	private Integer id;
	/**名前*/
	private String name;
	/**内容*/
	private String content;
	/**記事ID*/
	private Integer articleId;
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContent() {
		return content;
	}
	
	public Integer getArticleId() {
		return articleId;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", content=" + content + ", articleId=" + articleId + "]";
	}
	
}
