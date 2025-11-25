package dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SubscriptionDAO;
import model.User;

public class SubscriptionDAOImpl implements SubscriptionDAO {

   // channelId -> lista de suscriptores
    private final Map<Long, List<User>> subscribersByChannel = new HashMap<>();

    @Override
    public List<User> findSubscribersByChannelId(Long channelId) {
        return subscribersByChannel.getOrDefault(channelId, Collections.emptyList());
    }

    // Métodos de ayuda para montar el ejemplo en main()
    public void addSubscriber(Long channelId, User user) {
        List<User> list = subscribersByChannel.computeIfAbsent(channelId, id -> new ArrayList<>());
        list.add(user);
    }

}
