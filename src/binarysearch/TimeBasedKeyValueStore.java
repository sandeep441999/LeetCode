package binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    static class Pair {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Pair>> timeMap;

    public TimeBasedKeyValueStore() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";
        List<Pair> list = timeMap.get(key);

        int l = 0, r = list.size() - 1;
        String ans = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;
            Pair pair = list.get(mid);

            if (pair.timestamp <= timestamp) {
                ans = pair.value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
