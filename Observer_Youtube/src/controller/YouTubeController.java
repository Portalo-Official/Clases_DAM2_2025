package controller;

import service.VideoService;

public class YouTubeController {
	private final VideoService videoService;

	public YouTubeController(VideoService videoService) {
	        this.videoService = videoService;
	    }

	
	public void uploadVideo(String canalId, String titulo, String url) {

		videoService.subirVideo(canalId, titulo, url);
	}
}
