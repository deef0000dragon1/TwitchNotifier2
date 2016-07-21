package tech.deef.twitch;

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
