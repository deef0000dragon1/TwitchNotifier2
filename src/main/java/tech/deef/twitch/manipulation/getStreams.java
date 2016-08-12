package tech.deef.twitch.manipulation;

import java.util.ArrayList;

import tech.deef.twitch.domain.StreamsUser;
import tech.deef.twitch.external.TwitchAPI;

public class getStreams {

	private TwitchAPI puller;
	
	public getStreams(TwitchAPI puller){
		this.puller = puller;
	}
	
	public String[] getLiveStreams(String[] streams){
		StreamsUser user = null;
		ArrayList<String> liveUsers = new ArrayList();
		for(String testUser: streams){
			user = puller.getStreamsUser(testUser);
			if(user.getStream()!=null){
				liveUsers.add(testUser);
			}
		}
		return (String[]) liveUsers.toArray();
	}
}
