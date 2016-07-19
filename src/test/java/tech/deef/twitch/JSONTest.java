package tech.deef.twitch;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

public class JSONTest {

	@Test
	public void testCallAPI() {

		URL url;
		InputStream inpusStream = null;
		BufferedReader bufferedReader;
		String data = null;

		try {
			url = new URL("https://api.twitch.tv/kraken/users/deef0000dragon1/follows/channels");
			inpusStream = url.openStream(); // throws an IOException
			bufferedReader = new BufferedReader(new InputStreamReader(inpusStream));

			data = bufferedReader.readLine();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (inpusStream != null)
					inpusStream.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		assertNotNull(data);
	}

	@Test
	public void testDeserialization() {
		URL url;
		InputStream inpusStream = null;
		BufferedReader bufferedReader;
		String data = null;

		try {
			url = new URL("https://api.twitch.tv/kraken/users/deef0000dragon1/follows/channels");
			inpusStream = url.openStream(); // throws an IOException
			bufferedReader = new BufferedReader(new InputStreamReader(inpusStream));

			data = bufferedReader.readLine();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (inpusStream != null)
					inpusStream.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		
		
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
