package notification.bridge.implementation;

public class SmsChannel implements NotificationChannel {

    @Override
    public void send(String destination, String message) {
        System.out.println("Enviando SMS a " + destination + ": " + message);
    }

}
