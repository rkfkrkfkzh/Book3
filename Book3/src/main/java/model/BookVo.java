package model;

public class BookVo {
	private int num;
	private String title;
	private String author;
	private String publisher;
	private String content;

	public BookVo(int num, String title, String author, String publisher, String content) {
		//4개의 매개변수를 갖는 생성자를 정의
		super();
		this.num = num;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.content = content;
	}

	@Override
	public String toString() {
		return "BookVO [num=" + num + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", content=" + content + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
