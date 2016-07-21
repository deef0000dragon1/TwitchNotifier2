package tech.deef.twitch.external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tech.deef.twitch.domain.UserFollowsChannels;

public class TwitchAPIPull implements TwitchAPI {

	public UserFollowsChannels getUserFollowsChannels(String user) {
		
		
		URL url;
		InputStream inputStream = null;
		BufferedReader bufferedReader;
		String data = null;
		String link = "https://api.twitch.tv/kraken/users/" + user + "/follows/channels?direction=DESC&limit=50&offset=0&sortby=created_a";

		try {
			url = new URL(link);
			inputStream = url.openStream(); // throws an IOException
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			data = bufferedReader.readLine();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		
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

}
