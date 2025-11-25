package notification.bridge.implementation;

public interface NotificationChannel {
	void send(String destination, String message);
}
