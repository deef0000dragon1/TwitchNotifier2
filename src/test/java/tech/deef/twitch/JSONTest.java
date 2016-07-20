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
		String data = FetchRawJSON.fetchJSON("https://api.twitch.tv/kraken/users/deef0000dragon1/follows/channels");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(48,ufc.getTotal());
		
	}
}
