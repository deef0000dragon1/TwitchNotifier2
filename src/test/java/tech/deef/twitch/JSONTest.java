package tech.deef.twitch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTest {

	@Test
	public void testCallAPI() {
		String data = FetchRawJSON.fetchJSON("https://api.twitch.tv/kraken/users/deef0000dragon1/follows/channels?direction=DESC&limit=50&offset=0&sortby=created_a");
		assertNotNull(data);
	}

	@Test
	public void testCallAPIFile() {
		File file = new File("Files/TestFiles/JSONTest Json");
		String data = FetchRawJSON.fetchJSON(file);
		assertNotNull(data);
	}

	@Test
	public void testDeserialization() {

		File file = new File("Files/TestFiles/JSONTest Json");
		String data = FetchRawJSON.fetchJSON(file);

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

		assertEquals(48, ufc.getTotal());

	}
	
	@Test
	public void testDeserializationArray() {

		File file = new File("Files/TestFiles/JSONTest Json");
		String data = FetchRawJSON.fetchJSON(file);

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

		for(Followed f: ufc.getFollows()){
			System.out.println(f.getChannel().getDisplayName());
		}
		
		assertEquals("AlexSavageOMFG",ufc.getFollows().get(0).getChannel().getDisplayName());
		
		
	}
}
