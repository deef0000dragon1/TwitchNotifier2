package tech.deef.twitch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchRawJSON {
	public static String fetchJSON(String link){
		URL url;
		InputStream inpusStream = null;
		BufferedReader bufferedReader;
		String data = null;

		try {
			url = new URL(link);
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
		return data;
	}
}
