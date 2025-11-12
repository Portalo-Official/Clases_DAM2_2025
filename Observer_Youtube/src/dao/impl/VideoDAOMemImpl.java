package dao.impl;

import dao.VideoDAO;
import model.Video;

public class VideoDAOMemImpl implements VideoDAO {

	@Override
    public void guardar(Video video) {
        System.out.println("[BBDD] Guardado video: " + video.getTitulo()
                + " (" + video.getUrl() + ") del canal " + video.getCanalId());
    }

}
