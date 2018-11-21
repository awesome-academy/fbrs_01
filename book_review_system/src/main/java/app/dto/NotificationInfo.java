package app.dto;

import java.util.Date;

public class NotificationInfo {

	private Integer id;
	private UserInfo user;
	private ReviewInfo review;
	private String content;
	private int watched;
	private Integer userId;
	private Integer reviewId;
	private Date createdAt;

	public NotificationInfo() {
	}

	public NotificationInfo(Integer id, UserInfo user, ReviewInfo review, String content) {
		this.id = id;
		this.user = user;
		this.review = review;
		this.content = content;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public ReviewInfo getReview() {
		return review;
	}

	public void setReview(ReviewInfo review) {
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
