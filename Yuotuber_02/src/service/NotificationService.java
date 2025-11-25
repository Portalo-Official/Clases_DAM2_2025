package service;

import model.Video;

public interface NotificationService {

	 public void notifyNewVideo(Long channelId, Video video);
}
