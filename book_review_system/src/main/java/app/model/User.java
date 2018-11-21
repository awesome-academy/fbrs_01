package app.model;

import java.util.List;

public class User {
	private Integer id;
	private String fullName;
	private String userName;
	private String password;
	private String phoneNumber;
	private String email;
	private Role role;
	private List<Follow> followers;
	private List<Follow> followeds;
	private List<Like> likes;
	private List<Activity> activities;
	private List<Request> requests;
	private List<Mark> marks;
	private List<Review> reviews;
	private List<Comment> comments;
	private List<Notification> notifications;

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public User() {
	}
	public User(Integer id) {
		this.id = id;
	}

	public User(Integer id, String fullName, String userName, String password, String phoneNumber, String email,
			Role role, List<Follow> followers, List<Follow> followeds, List<Like> likes, List<Activity> activities,
			List<Request> requests, List<Mark> marks, List<Review> reviews, List<Comment> comments) {
		this.id = id;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.role = role;
		this.followers = followers;
		this.followeds = followeds;
		this.likes = likes;
		this.activities = activities;
		this.requests = requests;
		this.marks = marks;
		this.reviews = reviews;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Follow> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follow> followers) {
		this.followers = followers;
	}

	public List<Follow> getFolloweds() {
		return followeds;
	}

	public void setFolloweds(List<Follow> followeds) {
		this.followeds = followeds;
	}
}
