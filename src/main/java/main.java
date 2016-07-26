import java.util.ArrayList;

import tech.deef.twitch.domain.Stream;
import tech.deef.twitch.domain.StreamsUser;
import tech.deef.twitch.domain.UserFollowsChannels;
import tech.deef.twitch.external.TwitchAPIPull;

public class main {

	public static void main(String[] args){
		
		TwitchAPIPull puller = new TwitchAPIPull();
		ArrayList<StreamsUser> pre = new ArrayList();
		ArrayList<StreamsUser> post = new ArrayList();
		String userName = "Deef0000dragon1";
		String name = null;
		
		
		UserFollowsChannels ufc = puller.getUserFollowsChannels(userName);
		for(int i = 0; i < ufc.getTotal(); i++){
			
			name = ufc.getFollows().get(i).getChannel().getDisplayName();
			pre.add(puller.getStreamsUser(name));
			
			if(pre.get(pre.size()-1).getStream() != null){
				ding(pre.get(pre.size()-1).getStream());
			}
		}
		
		
		
		
		
		while(true){
			
			ufc = puller.getUserFollowsChannels(userName);
			for(int i = 0; i < ufc.getTotal(); i++){
				
				name = ufc.getFollows().get(i).getChannel().getDisplayName();
				post.add(puller.getStreamsUser(name));
				
				if(post.get(post.size()-1).getStream() != null && pre.get(post.size()-1).getStream() == null){
					ding(post.get(post.size()-1).getStream());
				}
			}

			
			pre = null;
			pre = post;
			post = null;
			
			//sleep thread
			try {
				System.out.println("*");
				Thread.sleep(60*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private static void ding(Stream stream) {
		
		System.out.println(stream.getChannel().getDisplayName() + " just went live");
		System.out.println("  "+stream.getChannel().getStatus());
		System.out.println("  Playing: " + stream.getGame() + "\n");
		
	}
}
