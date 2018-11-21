package app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.mail.MailSender;

import app.dao.ActivityDAO;
import app.dao.BookDAO;
import app.dao.CategoryDAO;
import app.dao.CommentDAO;
import app.dao.FollowDAO;
import app.dao.MarkDAO;
import app.dao.NotificationDAO;
import app.dao.RequestDAO;
import app.dao.ReviewDAO;
import app.dao.RoleDAO;
import app.dao.UserDAO;

public class BaseServiceImpl {
	protected RoleDAO roleDAO;
	protected UserDAO userDAO;
	protected BookDAO bookDAO;
	protected ReviewDAO reviewDAO;
	protected ActivityDAO activityDAO;
	protected CategoryDAO categoryDAO;
	protected FollowDAO followDAO;
	protected CommentDAO commentDAO;
	protected MarkDAO markDAO;
	protected RequestDAO requestDAO;
	protected MailSender mailSender;
	protected NotificationDAO notificationDAO;
	@Autowired
	protected ReloadableResourceBundleMessageSource messageSource;

	public MarkDAO getMarkDAO() {
		return markDAO;
	}

	public RequestDAO getRequestDAO() {
		return requestDAO;
	}

	public void setRequestDAO(RequestDAO requestDAO) {
		this.requestDAO = requestDAO;
	}

	public void setMarkDAO(MarkDAO markDAO) {
		this.markDAO = markDAO;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public ReviewDAO getReviewDAO() {
		return reviewDAO;
	}

	public void setReviewDAO(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}

	public ActivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	public FollowDAO getFollowDAO() {
		return followDAO;
	}

	public void setFollowDAO(FollowDAO followDAO) {
		this.followDAO = followDAO;
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public ReloadableResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(ReloadableResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public NotificationDAO getNotificationDAO() {
		return notificationDAO;
	}

	public void setNotificationDAO(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}

}