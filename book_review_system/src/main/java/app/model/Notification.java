package app.model;

import java.util.Date;

public class Notification {
	private Integer id;
	private User user;
	private Review review;
	private String content;
	private int  watched;
	private Date createdAt;

	public Notification() {
	}

	public Notification(Integer id, User user, Review review, String content, int watched) {
		this.id = id;
		this.user = user;
		this.review = review;
		this.content = content;
		this.watched = watched;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getWatched() {
		return watched;
	}

	public void setWatched(int watched) {
		this.watched = watched;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
