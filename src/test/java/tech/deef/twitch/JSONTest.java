package tech.deef.twitch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tech.deef.twitch.domain.UserFollowsChannels;

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

		//for(Followed f: ufc.getFollows()){System.out.println(f.getChannel().getDisplayName());}
				
		assertEquals("AlexSavageOMFG",ufc.getFollows().get(0).getChannel().getDisplayName());
		assertEquals("ArcadePit",ufc.getFollows().get(1).getChannel().getDisplayName());
		assertEquals("TryFoldMusic",ufc.getFollows().get(2).getChannel().getDisplayName());
		assertEquals("awesomesaucenetwork",ufc.getFollows().get(3).getChannel().getDisplayName());
		assertEquals("BobRoss",ufc.getFollows().get(4).getChannel().getDisplayName());
		assertEquals("RoraxPlays",ufc.getFollows().get(5).getChannel().getDisplayName());
		assertEquals("WVPhotoJ",ufc.getFollows().get(6).getChannel().getDisplayName());
		assertEquals("FractalJosh",ufc.getFollows().get(7).getChannel().getDisplayName());
		assertEquals("ThatOneVideoGamer",ufc.getFollows().get(8).getChannel().getDisplayName());
		assertEquals("Exfauxsure",ufc.getFollows().get(9).getChannel().getDisplayName());
		assertEquals("Jimquisition",ufc.getFollows().get(10).getChannel().getDisplayName());
		assertEquals("topdownperspective",ufc.getFollows().get(11).getChannel().getDisplayName());
		assertEquals("Geoff",ufc.getFollows().get(12).getChannel().getDisplayName());
		assertEquals("PurpleMentat",ufc.getFollows().get(13).getChannel().getDisplayName());
		assertEquals("frozentrually",ufc.getFollows().get(14).getChannel().getDisplayName());
		assertEquals("Totalbiscuit",ufc.getFollows().get(15).getChannel().getDisplayName());
		assertEquals("Scizon",ufc.getFollows().get(16).getChannel().getDisplayName());
		assertEquals("Kylelandrypiano",ufc.getFollows().get(17).getChannel().getDisplayName());
		assertEquals("SethBling",ufc.getFollows().get(18).getChannel().getDisplayName());
		assertEquals("Spikevegeta",ufc.getFollows().get(19).getChannel().getDisplayName());
		assertEquals("Almolicious",ufc.getFollows().get(20).getChannel().getDisplayName());
		assertEquals("GamesWithHank",ufc.getFollows().get(21).getChannel().getDisplayName());
		assertEquals("GrandStarYoshi",ufc.getFollows().get(22).getChannel().getDisplayName());
		assertEquals("Jaysvfx",ufc.getFollows().get(23).getChannel().getDisplayName());
		assertEquals("mDiyo",ufc.getFollows().get(24).getChannel().getDisplayName());
		assertEquals("XCompWiz",ufc.getFollows().get(25).getChannel().getDisplayName());
		assertEquals("Aavak",ufc.getFollows().get(26).getChannel().getDisplayName());
		assertEquals("Barnacules",ufc.getFollows().get(27).getChannel().getDisplayName());
		assertEquals("LightningPlays",ufc.getFollows().get(28).getChannel().getDisplayName());
		assertEquals("Thelightningspirit78",ufc.getFollows().get(29).getChannel().getDisplayName());
		assertEquals("ProtonJon",ufc.getFollows().get(30).getChannel().getDisplayName());
		assertEquals("Runnerguy2489",ufc.getFollows().get(31).getChannel().getDisplayName());
		assertEquals("Briarstone",ufc.getFollows().get(32).getChannel().getDisplayName());
		assertEquals("misskaddykins",ufc.getFollows().get(33).getChannel().getDisplayName());
		assertEquals("wotc_DnD",ufc.getFollows().get(34).getChannel().getDisplayName());
		assertEquals("DeusQain",ufc.getFollows().get(35).getChannel().getDisplayName());
		assertEquals("GamesDoneQuick",ufc.getFollows().get(36).getChannel().getDisplayName());
		assertEquals("Jefmajor",ufc.getFollows().get(37).getChannel().getDisplayName());
		assertEquals("BeerGamesBeer",ufc.getFollows().get(38).getChannel().getDisplayName());
		assertEquals("brynnagiadrosich",ufc.getFollows().get(39).getChannel().getDisplayName());
		assertEquals("4KbShort",ufc.getFollows().get(40).getChannel().getDisplayName());
		assertEquals("Arumba07",ufc.getFollows().get(41).getChannel().getDisplayName());
		assertEquals("Luke_Lafr",ufc.getFollows().get(42).getChannel().getDisplayName());
		assertEquals("ParadoxInteractive",ufc.getFollows().get(43).getChannel().getDisplayName());
		assertEquals("Skrumpei",ufc.getFollows().get(44).getChannel().getDisplayName());
		assertEquals("LinusTech",ufc.getFollows().get(45).getChannel().getDisplayName());
		assertEquals("Soaryn",ufc.getFollows().get(46).getChannel().getDisplayName());
		assertEquals("jadedcat",ufc.getFollows().get(47).getChannel().getDisplayName());
	}

}
