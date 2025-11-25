package observer;

import model.Video;

public interface Subscriber {
    void onNewVideo(Video video);
}
