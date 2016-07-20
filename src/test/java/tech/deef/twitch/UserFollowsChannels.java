package tech.deef.twitch;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFollowsChannels {

	@JsonProperty("_total")
	private int total;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("follows")
	private ArrayList<Followed> follows;

	public int getTotal() {
		return total;
	}

	public Links getLinks() {
		return links;
	}

	public ArrayList<Followed> getFollows() {
		return follows;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public void setFollows(ArrayList<Followed> follows) {
		this.follows = follows;
	}
	
	
}
