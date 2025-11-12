package observable;

import model.VideoPublicado;

public interface ObserverVideo {
	// esto es el update(context) en los apuntes
	 void videoPublicado(VideoPublicado evento);
}
