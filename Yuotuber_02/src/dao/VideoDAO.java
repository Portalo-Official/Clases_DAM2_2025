package dao;

import java.util.List;

import model.Video;

public interface VideoDAO {
	Video save(Video video);
    List<Video> findAll();
}
