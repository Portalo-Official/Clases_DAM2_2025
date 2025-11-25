package dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.VideoDAO;
import model.Video;

public class VideoDAOImpl implements VideoDAO{

    private final Map<Long, Video> storage = new HashMap<>();
    private long sequence = 1L;

    @Override
    public Video save(Video video) {
        if (video.getId() == null) {
            video.setId(sequence++);
        }
        storage.put(video.getId(), video);
        return video;
    }

    @Override
    public List<Video> findAll() {
        return new ArrayList<>(storage.values());
    }
}
