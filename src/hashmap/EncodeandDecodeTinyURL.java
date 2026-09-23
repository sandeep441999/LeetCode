package hashmap;

import java.util.HashMap;
import java.util.Map;

public class EncodeandDecodeTinyURL {
    Map<String, String> encode;
    Map<String, String> decode;

    public EncodeandDecodeTinyURL() {
        encode = new HashMap<>();
        decode = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (!encode.containsKey(longUrl)) {
            String key = String.valueOf(encode.size() + 1);
            encode.put(longUrl, key);
            decode.put(key, longUrl);
        }
        return encode.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decode.get(shortUrl);
    }
}
