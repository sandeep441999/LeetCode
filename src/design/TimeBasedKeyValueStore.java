package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    // Map<String, TreeMap<Integer, List<String>>> timeMap;
    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // timeMap.computeIfAbsent(key, k -> new TreeMap<>()).computeIfAbsent(timestamp,
        // k -> new ArrayList<>()).add(value);
        timeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";
        // TreeMap<Integer, List<String>> map = timeMap.get(key);
        TreeMap<Integer, String> map = timeMap.get(key);
        if (map.containsKey(timestamp)) {
            // return map.get(timestamp).get(0);
            return map.get(timestamp);
        } else {
            if (map.floorKey(timestamp) == null)
                return "";
            // return map.get(map.floorKey(timestamp)).get(0);
            return map.get(map.floorKey(timestamp));
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
