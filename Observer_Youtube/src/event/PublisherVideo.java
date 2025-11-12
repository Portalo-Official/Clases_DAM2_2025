package event;

import model.VideoPublicado;
import observable.ObserverVideo;

public interface PublisherVideo {
    void suscribir(ObserverVideo o);
    void desuscribir(ObserverVideo o);
    void publicar(VideoPublicado evento);
}
