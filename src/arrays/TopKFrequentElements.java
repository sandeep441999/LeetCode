package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            // if(!map.containsKey(x)) {
            // map.put(x, 1);
            // } else {
            // map.put(x, map.get(x)+1);
            // }
            map.merge(x, 1, Integer::sum);
        }

        List<Integer>[] b = new List[nums.length + 1];

        for (int x : map.keySet()) {
            if (b[map.get(x)] == null) {
                b[map.get(x)] = new ArrayList<>();
            }
            b[map.get(x)].add(x);
        }
        // PriorityQueue<Integer> q = new PriorityQueue<>((e1, e2) -> map.get(e2) -
        // map.get(e1));
        int[] res = new int[k];
        // q.addAll(map.keySet());

        // for(int i=0; i<k; i++) {
        // res[i] = q.poll();
        // }
        int l = 0;
        for (int i = b.length - 1; i >= 0; i--) {
            if (b[i] != null) {
                for (int x : b[i]) {
                    res[l] = x;
                    l++;
                    if (l == k)
                        return res;
                }
            }

        }

        return res;
    }
}
