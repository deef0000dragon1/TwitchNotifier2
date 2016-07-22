package tech.deef.twitch.external;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tech.deef.twitch.domain.ChannelsUser;
import tech.deef.twitch.domain.StreamsUser;
import tech.deef.twitch.domain.UserFollowsChannels;

public class TwitchAPIPull implements TwitchAPI {

	public UserFollowsChannels getUserFollowsChannels(String user) {
		String link = "https://api.twitch.tv/kraken/users/" + user
				+ "/follows/channels?direction=DESC&limit=50&offset=0&sortby=created_a";
		DataPull puller = new DataPuller();
		String data = puller.PullData(link);

		ObjectMapper mapper = new ObjectMapper();
		UserFollowsChannels ufc = null;

		try {
			ufc = mapper.readValue(data, UserFollowsChannels.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ufc;
	}

	public StreamsUser getStreamsUser(String user) {
		String link = "https://api.twitch.tv/kraken/streams/" + user;
		DataPull puller = new DataPuller();
		String data = puller.PullData(link);

		ObjectMapper mapper = new ObjectMapper();
		StreamsUser su = null;

		try {
			su = mapper.readValue(data, StreamsUser.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return su;
	}

	public ChannelsUser getChannelsUser(String user) {
		String link = "https://api.twitch.tv/kraken/channels/" + user;
		DataPull puller = new DataPuller();
		String data = puller.PullData(link);

		ObjectMapper mapper = new ObjectMapper();
		ChannelsUser cu = null;

		try {
			cu = mapper.readValue(data, ChannelsUser.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cu;
	}

}
