package app.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import app.dto.NotificationInfo;
import app.dto.ReviewInfo;
import app.dto.UserInfo;
import app.model.Notification;
import app.model.Review;
import app.model.User;
import app.service.NotificationService;

public class NotificationServiceImpl extends BaseServiceImpl implements NotificationService {

	public Logger logger = Logger.getLogger(NotificationServiceImpl.class);

	@Override
	public UserInfo getUser(Integer notificationId) {
		try {
			return ConvertModelToBean.mapUserToUserInfo(notificationDAO.getUser(notificationId));
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public ReviewInfo getReview(Integer notificationId) {
		try {
			return ConvertModelToBean.mapReviewToReviewInfo(notificationDAO.getReview(notificationId));
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public NotificationInfo findById(int id) {
		try {
			return ConvertModelToBean.toNotificationInfo(notificationDAO.findByIdLock(id, true));
		} catch (Exception e) {
			logger.error(e);
			return null;
		}

	}

	@Override
	public NotificationInfo saveOrUpdate(NotificationInfo entity) {
		try {
			notificationDAO.saveOrUpdate(toNotification(entity));
			return entity;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	// ------------ PRIVATE -------------
	private Notification toNotification(NotificationInfo notificationInfo) {
		Notification notification = notificationDAO.findById(notificationInfo.getId());
		if (notification == null) {
			notification = new Notification();
			notification.setId(notificationInfo.getId());
			notification.setUser(new User(notificationInfo.getUser().getId()));
			notification.setId(notificationInfo.getId());
			notification.setReview(new Review(notificationInfo.getReview().getId()));
		}
		notification.setContent(notificationInfo.getContent());
		notification.setWatched(notificationInfo.getWatched());
		return notification;
	}

	@Override
	public List<NotificationInfo> notifications() {
		try {
			return ConvertModelToBean.mapListNotificationToNotificationInfo((notificationDAO.notifications()));
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

}
