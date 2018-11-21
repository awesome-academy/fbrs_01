package app.websocket;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import app.dto.NotificationInfo;
import app.service.NotificationService;

@Controller
public class NotificationsController {
	private static final Logger logger = Logger.getLogger(NotificationsController.class);
	@Autowired
	private NotificationService notificationService;
	
	@MessageMapping("update/{id}")
	public void update(@DestinationVariable("id") Integer id) {
		NotificationInfo notificationInfo = notificationService.findById(id);
		notificationInfo.setWatched(1);
		notificationService.saveOrUpdate(notificationInfo);
	}


}
