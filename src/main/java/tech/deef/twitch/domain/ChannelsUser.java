package tech.deef.twitch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelsUser extends Channel{
	//this class exists sole for clarity purposes 
	//as all JSON Fields are handled by Channel
}
