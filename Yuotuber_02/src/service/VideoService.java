package service;

import model.Video;

public interface VideoService {
    public Video uploadVideo(Long channelId, String title, String url);
}
