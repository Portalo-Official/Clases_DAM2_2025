package notification.factory;

import model.NotificationPreference;
import notification.bridge.implementation.EmailChannel;
import notification.bridge.implementation.NotificationChannel;
import notification.bridge.implementation.PushChannel;
import notification.bridge.implementation.SmsChannel;

public class NotificationChannelFactory {
	 public static NotificationChannel fromPreference(NotificationPreference preference) {
	        switch (preference) {
	            case SMS:
	                return new SmsChannel();
	            case PUSH:
	                return new PushChannel();
	            case EMAIL:
	            default:
	                return new EmailChannel();
	        }
	    }
}
