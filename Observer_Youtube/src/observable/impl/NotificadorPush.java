package observable.impl;

import model.VideoPublicado;
import observable.ObserverVideo;

public class NotificadorPush implements ObserverVideo {

	@Override
	public void videoPublicado(VideoPublicado evento) {
		//Logica para notificar al movil
		 System.out.println("[PUSH] Canal " + evento.getCanalId() + " publicó " + evento.getTitulo());
		 
	}

}
