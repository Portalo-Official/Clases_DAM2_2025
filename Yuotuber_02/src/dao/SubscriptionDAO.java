package dao;

import java.util.List;

import model.User;

public interface SubscriptionDAO {
	 List<User> findSubscribersByChannelId(Long channelId);
}
