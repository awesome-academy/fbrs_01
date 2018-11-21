package app.model;

import java.util.Date;
import java.util.List;

public class Review {
	private Integer id;
	private float numberOfStar;
	private String content;
	private Date createdAt;
	private Book book;
	private User user;
	private List<Comment> comments;
	private List<Notification> notifications;

	public Review() {

	}
	public Review(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getNumberOfStar() {
		return numberOfStar;
	}

	public void setNumberOfStar(float numberOfStar) {
		this.numberOfStar = numberOfStar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
}
