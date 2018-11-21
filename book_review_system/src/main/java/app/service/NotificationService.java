package app.service;

import java.util.List;

import app.dto.NotificationInfo;
import app.dto.ReviewInfo;
import app.dto.UserInfo;

public interface NotificationService {
	UserInfo getUser(Integer notificationId);

	ReviewInfo getReview(Integer notificationId);

	NotificationInfo findById(int id);

	NotificationInfo saveOrUpdate(NotificationInfo entity);
	
	List<NotificationInfo> notifications();

}
