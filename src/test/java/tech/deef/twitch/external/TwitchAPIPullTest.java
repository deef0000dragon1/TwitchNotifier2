package tech.deef.twitch.external;

import static org.junit.Assert.*;

import org.junit.Test;

import tech.deef.twitch.domain.UserFollowsChannels;
import tech.deef.twitch.external.TwitchAPIPull;


public class TwitchAPIPullTest {

	@Test
	public void testGetUserFollowsChannels() {
		TwitchAPIPull pull = new TwitchAPIPull();
		UserFollowsChannels ufc = pull.getUserFollowsChannels("deef0000dragon1");
		assertNotNull(ufc);
		
		
		assertEquals("AlexSavageOMFG",ufc.getFollows().get(0).getChannel().getDisplayName());
		assertEquals("jadedcat",ufc.getFollows().get(47).getChannel().getDisplayName());
		
	}
}
