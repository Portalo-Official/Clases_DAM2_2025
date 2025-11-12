package event.impl;

import java.util.ArrayList;
import java.util.List;

import event.PublisherVideo;
import model.VideoPublicado;
import observable.ObserverVideo;

public class EventPublisherInMemory implements PublisherVideo {

	private final List<ObserverVideo> observers ;

	public EventPublisherInMemory() {
		super();
		observers = new ArrayList<>();
	}

	@Override
	public void suscribir(ObserverVideo o) {
		observers.add(o);
	}

	@Override
	public void desuscribir(ObserverVideo o) {
		observers.remove(o);
	}

	@Override
	public void publicar(VideoPublicado e) {
		for (ObserverVideo o : observers) {
			try {
				o.videoPublicado(e);
			} catch (Exception ex) {
				System.err.println("[WARN] Observer falló: " + o.getClass().getSimpleName() + " -> " + ex.getMessage());
			}
		}
	}
}
