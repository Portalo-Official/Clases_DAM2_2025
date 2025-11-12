package bootstrap;

import controller.YouTubeController;
import dao.VideoDAO;
import dao.impl.VideoDAOMemImpl;
import event.impl.EventPublisherInMemory;
import observable.ObserverVideo;
import observable.impl.IndexadorAnalytics;
import observable.impl.NotificadorEmail;
import observable.impl.NotificadorPush;
import service.VideoService;
import service.impl.VideoServiceImpl;

public class Main {

    public static void main(String[] args) {
        // Infra
        VideoDAO repo = new VideoDAOMemImpl();
        EventPublisherInMemory eventBus = new EventPublisherInMemory();

        // Observers registrados
        ObserverVideo email = new NotificadorEmail();
        ObserverVideo push = new NotificadorPush();
        ObserverVideo analytics = new IndexadorAnalytics();
        eventBus.suscribir(email);
        eventBus.suscribir(push);
        eventBus.suscribir(analytics);

        // Service y Controller
        VideoService videoService = new VideoServiceImpl(repo, eventBus);
        YouTubeController controller = new YouTubeController(videoService);

        // “Llamada HTTP” simulada
        controller.uploadVideo("ManoloSoldador", "Como soldar el titanic en 5 min", "https://youtu.be/xyz");
    }
}
