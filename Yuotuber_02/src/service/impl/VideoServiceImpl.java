package service.impl;

import dao.VideoDAO;
import model.Video;
import service.NotificationService;
import service.VideoService;

public class VideoServiceImpl implements VideoService{

	private VideoDAO videoDAO;
	private final NotificationService notificationService;

	public VideoServiceImpl(VideoDAO videoDAO, NotificationService notificationService) {
		super();
		this.videoDAO = videoDAO;
		this.notificationService = notificationService;
	}
	
	@Override
	public Video uploadVideo(Long channelId, String title, String url) {
		  // 1. Crear entidad
        Video video = new Video(channelId, title, url);
        video.setTitle(title);
        video.setUrl(url);

        // 2. Guardar en el "DAO"
        Video saved = videoDAO.save(video);

        // 3. Notificar a los suscriptores (Observer + Bridge + Factory)
        notificationService.notifyNewVideo(channelId, saved);

        return saved;
	}

}
