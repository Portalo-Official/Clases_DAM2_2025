package app;

import controller.VideoController;
import dao.SubscriptionDAO;
import dao.VideoDAO;
import dao.impl.SubscriptionDAOImpl;
import dao.impl.VideoDAOImpl;
import model.NotificationPreference;
import model.User;
import service.NotificationService;
import service.VideoService;
import service.impl.NotificationServiceImpl;
import service.impl.VideoServiceImpl;

public class Main {

	public static void main(String[] args) {
//		DAO
        VideoDAO videoRepository = new VideoDAOImpl();
        SubscriptionDAO subscriptionDAO = new SubscriptionDAOImpl();

        // Creamos suscriptores de ejemplo
        User u1 = new User(1L, "Ana", "ana@example.com", "601656069", NotificationPreference.EMAIL);

        User u2 = new User(2L, "Luis", "luis@example.com", "621756779", NotificationPreference.PUSH);

        Long channelId = 100L;
//        subscriptionDAO.addSubscriber(channelId, u1);
//        subscriptionDAO.addSubscriber(channelId, u2);

        // NotificationService (usa Bridge + Factory por dentro)
        NotificationService notificationService = new NotificationServiceImpl(subscriptionDAO);

        // VideoService
        VideoService videoService = new VideoServiceImpl(videoRepository, notificationService);

        // Controller
        VideoController controller = new VideoController(videoService);

        // Simulamos una petición para subir un vídeo
        controller.uploadVideoEndpoint(channelId,
                "Como cuidar perro acuaticos",
                "https://mi-youtube-fake.com/video/bridge");
	}
	
}
