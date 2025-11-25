package notification.bridge.abstraction;

import model.User;
import model.Video;
import notification.bridge.implementation.NotificationChannel;

public class NewVideoNotification extends Notification{

	 public NewVideoNotification(NotificationChannel channel) {
	        super(channel);
	    }

	    @Override
	    public void send(User user, Video video) {
	        String message = "Hola " + user.getName()
	                + ", hay un nuevo vídeo: " + video.getTitle()
	                + " -> " + video.getUrl();

	        // Podrías usar email, teléfono, token push, etc.
	        String destination = user.getEmail(); // simplificado
	        channel.send(destination, message);
	    }
}
