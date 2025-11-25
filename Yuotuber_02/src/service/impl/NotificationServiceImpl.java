package service.impl;

import java.util.List;

import dao.SubscriptionDAO;
import model.User;
import model.Video;
import notification.bridge.abstraction.NewVideoNotification;
import notification.bridge.abstraction.Notification;
import notification.bridge.implementation.NotificationChannel;
import notification.factory.NotificationChannelFactory;
import service.NotificationService;

public class NotificationServiceImpl implements NotificationService{

	 private final SubscriptionDAO subscriptionDAO;

    public NotificationServiceImpl(SubscriptionDAO subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

	@Override
	public void notifyNewVideo(Long channelId, Video video) {
	    List<User> subscribers = subscriptionDAO.findSubscribersByChannelId(channelId);
		
	    for (User user : subscribers) {
	        NotificationChannel channel =
	                NotificationChannelFactory.fromPreference(user.getNotificationPreference());
	
	        Notification notification = new NewVideoNotification(channel);
	
	        notification.send(user, video);
	    }
	}
	
	
}
