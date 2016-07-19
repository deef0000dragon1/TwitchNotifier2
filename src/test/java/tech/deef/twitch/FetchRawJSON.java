package tech.deef.twitch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchRawJSON {
	public static String fetchJSON(String link){
		URL url;
		InputStream inputStream = null;
		BufferedReader bufferedReader;
		String data = null;

		try {
			url = new URL(link);
			inputStream = url.openStream(); // throws an IOException
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			data = bufferedReader.readLine();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		return data;
	}
	
	public static String fetchJSON(File file){
		InputStream inputStream = null;
		BufferedReader bufferedReader;
		String data = null;

		try {			
			inputStream = new FileInputStream(file);
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			data = bufferedReader.readLine();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		return data;
	}
	
}
