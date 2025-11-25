package notification.bridge.abstraction;

import model.User;
import model.Video;
import notification.bridge.implementation.NotificationChannel;

public abstract class Notification {

    protected NotificationChannel channel;

    protected Notification(NotificationChannel channel) {
        this.channel = channel;
    }

    public abstract void send(User user, Video video);
}
