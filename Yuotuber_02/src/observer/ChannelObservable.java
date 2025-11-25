package observer;

import model.Video;

public interface ChannelObservable {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers(Video video);
}
