package service.impl;

import dao.VideoDAO;
import event.PublisherVideo;
import model.Video;
import model.VideoPublicado;
import service.VideoService;

public class VideoServiceImpl implements VideoService{

    private final VideoDAO repo;
    private final PublisherVideo eventBus;

    public VideoServiceImpl(VideoDAO repo, PublisherVideo eventBus) {
        this.repo = repo;
        this.eventBus = eventBus;
    }

    public void subirVideo(String canalId, String titulo, String url) {
        // 1) Persistencia
        Video video = new Video(canalId, titulo, url);
        repo.guardar(video);

        // 2) Publicar evento (Observer)
        VideoPublicado evento = new VideoPublicado(
                canalId, titulo, url, System.currentTimeMillis());
        eventBus.publicar(evento);
        // el punto 2 aqui me mosquea, sabrías por que ? 
    
    }
}
