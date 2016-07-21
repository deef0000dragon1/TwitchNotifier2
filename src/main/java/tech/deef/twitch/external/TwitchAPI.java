package tech.deef.twitch.external;

import tech.deef.twitch.domain.UserFollowsChannels;

public interface TwitchAPI {

	public UserFollowsChannels getUserFollowsChannels(String user); 
	//public void getStreamsUser();
	//public void getChannelsUser();
}
