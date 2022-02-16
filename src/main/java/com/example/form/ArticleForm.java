package com.example.form;

/**
 * 記事を表示する時に使用するフォームです。
 * 
 * @author kashimamiyu
 *
 */
public class ArticleForm {
	
	/**名前 */
	private String name;
	/**内容 */
	private String content;
	
	public String getName() {
		return name;
	}
	
	public String getContent() {
		return content;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ArticleForm [name=" + name + ", content=" + content + "]";
	}

}
