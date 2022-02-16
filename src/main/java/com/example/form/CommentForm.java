package com.example.form;

/**
 * コメントを表示する時に使用するフォームです。
 * 
 * @author kashimamiyu
 *
 */
public class CommentForm {

	/**記事ID */
	private String articleId;
	/**名前*/
	private String name;
	/**内容*/
	private String content;
	
	public String getArticleId() {
		return articleId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContent() {
		return content;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentForm [articleId=" + articleId + ", name=" + name + ", content=" + content + "]";
	}

}
