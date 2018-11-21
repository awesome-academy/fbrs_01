package app.dao;

import java.util.List;

import app.model.Notification;
import app.model.Review;
import app.model.User;

public interface NotificationDAO extends BaseDAO<Integer, Notification> {
	User getUser(Integer notificationId);

	Review getReview(Integer notificationId);

	Notification findByIdLock(int id, boolean lock);
	
	List<Notification> notifications();
}
