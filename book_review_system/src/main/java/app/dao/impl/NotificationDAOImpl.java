package app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Restrictions;

import app.dao.GenericDAO;
import app.dao.NotificationDAO;
import app.model.Notification;
import app.model.Review;
import app.model.User;

public class NotificationDAOImpl extends GenericDAO<Integer, Notification> implements NotificationDAO {

	@SuppressWarnings("deprecation")
	@Override
	public User getUser(Integer notificationId) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.createAlias("notifications", "notifications", Criteria.LEFT_JOIN,
				Restrictions.eq("notifications.id", notificationId));
		return (User) criteria.uniqueResult();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Review getReview(Integer notificationId) {
		Criteria criteria = getSession().createCriteria(Review.class);
		criteria.createAlias("notifications", "notifications", Criteria.LEFT_JOIN,
				Restrictions.eq("notifications.id", notificationId));
		return (Review) criteria.uniqueResult();
	}

	@Override
	public Notification findByIdLock(int id, boolean lock) {
		return getSession().load(Notification.class, id, LockMode.PESSIMISTIC_WRITE);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Notification> notifications() {
		return getSession().createCriteria(Notification.class).list();
	}

}
