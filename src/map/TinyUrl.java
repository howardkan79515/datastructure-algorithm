package map;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {
	
	Map<String, String> urlMap = new HashMap<>();
	
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	int hash = longUrl.hashCode();
    	String tinyUrl = "http://tinyurl.com/"+hash;
    	if(urlMap.containsKey(tinyUrl)) {
    		encode(longUrl+"*");
    	}
    	urlMap.put(tinyUrl, longUrl);
		return tinyUrl;        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	String longUrl = urlMap.get(shortUrl);
    	if('*' == longUrl.charAt(longUrl.length()-1)) {
    		String origUrl = longUrl.substring(0, longUrl.length()-1);
    		return origUrl;
    	}
		return longUrl;        
    }

}
