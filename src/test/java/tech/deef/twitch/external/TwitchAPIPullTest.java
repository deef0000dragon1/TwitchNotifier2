package tech.deef.twitch.external;

import static org.junit.Assert.*;

import org.junit.Test;

import tech.deef.twitch.domain.ChannelsUser;
import tech.deef.twitch.domain.StreamsUser;
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
	@Test
	public void testGetChannelsUser() {
		TwitchAPIPull pull = new TwitchAPIPull();
		ChannelsUser cu = pull.getChannelsUser("deef0000dragon1");
		assertNotNull(cu);

		assertEquals("Deef0000dragon1", cu.getDisplayName());

		
		
	}
	@Test
	public void testGetStreamsUserNull() {
		TwitchAPIPull pull = new TwitchAPIPull();
		StreamsUser su = pull.getStreamsUser("deef0000dragon1");
		//tests I can pull user info
		assertNotNull(su);
		//makes sure a channel that is offline has no stream information
		assertNull(su.getStream());

		
		
	}
	
	
	@Test
	public void testGetStreamsUser() {
		String TestChannel = "BobRoss";
		
		//WARNING This test must be tuned to the information current avaliable
		//as such, the user in question may or may note be live. 
		TwitchAPIPull pull = new TwitchAPIPull();
		StreamsUser su = pull.getStreamsUser(TestChannel);
		assertNotNull(su);
		
		assertNotNull(su.getStream());
		assertEquals(TestChannel, su.getStream().getChannel().getDisplayName());
		
		
	}
}
