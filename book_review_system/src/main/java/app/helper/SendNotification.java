package app.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.FollowInfo;
import app.dto.NotificationInfo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Component
public class SendNotification {
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	public void send(NotificationInfo notificationInfo, List<FollowInfo> list) {
		notificationInfo.setUserId(notificationInfo.getUser().getId());
		notificationInfo.setReviewId(notificationInfo.getReview().getId());
		notificationInfo.setUser(null);
		notificationInfo.setReview(null);
		for (FollowInfo followInfo : list) {
			int id = followInfo.getFollower().getId();
			simpMessagingTemplate.convertAndSend("/topic/notifications/" + id, notificationInfo);
		}

	}

}
