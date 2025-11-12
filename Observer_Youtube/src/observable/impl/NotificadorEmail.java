package observable.impl;

import model.VideoPublicado;
import observable.ObserverVideo;

public class NotificadorEmail implements ObserverVideo {

	@Override
	public void videoPublicado(VideoPublicado evento) {

		System.out.println("[EMAIL] Nuevo video: " + evento.getTitulo() + " -> " + evento.getUrl());
	}

}
