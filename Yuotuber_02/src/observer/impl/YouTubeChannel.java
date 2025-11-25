package observer.impl;

import java.util.ArrayList;
import java.util.List;

import model.Video;
import observer.ChannelObservable;
import observer.Subscriber;

public class YouTubeChannel implements ChannelObservable  {
	private final List<Subscriber> subscribers = new ArrayList<>();

	@Override
	public void addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	@Override
	public void removeSubscriber(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}

	@Override
	public void notifySubscribers(Video video) {
		for (Subscriber subscriber : subscribers) {
			subscriber.onNewVideo(video);
		}
	}
}
