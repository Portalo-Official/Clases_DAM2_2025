package notification.bridge.implementation;

public class EmailChannel implements NotificationChannel {

	   @Override
	    public void send(String destination, String message) {
	        System.out.println("Enviando EMAIL a " + destination + ": " + message);
	    } 

}
