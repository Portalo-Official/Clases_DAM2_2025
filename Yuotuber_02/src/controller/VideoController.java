package controller;

import model.Video;
import service.VideoService;

public class VideoController {
	private final VideoService videoService;

	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}

	// Simulación de un endpoint: POST /channels/{channelId}/videos
	public void uploadVideoEndpoint(Long channelId, String title, String url) {
		System.out.println(">>> Petición para subir vídeo al canal " + channelId);

		Video saved = videoService.uploadVideo(channelId, title, url);

		System.out.println(">>> Vídeo subido correctamente con id = " + saved.getId());
	}
}
