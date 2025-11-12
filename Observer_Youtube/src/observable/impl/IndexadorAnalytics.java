package observable.impl;

import model.VideoPublicado;
import observable.ObserverVideo;

public class IndexadorAnalytics implements ObserverVideo {

	@Override
	public void videoPublicado(VideoPublicado evento) {
		System.out.println("[ANALITYCS] - Video registrado para las analiticas");
	}

}
