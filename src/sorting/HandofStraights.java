package sorting;

import java.util.Arrays;
import java.util.HashMap;

public class HandofStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize > 0)
            return false;
        Arrays.sort(hand);

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : hand) {
            freq.merge(x, 1, Integer::sum);
        }

        for (int i = 0; i < hand.length; i++) {
            if (freq.get(hand[i]) > 0) {
                int cur = hand[i];
                for (int j = 1; j < groupSize; j++) {
                    if (freq.getOrDefault(cur + 1, 0) > 0) {
                        freq.merge(cur + 1, -1, Integer::sum);
                        cur++;
                    } else {
                        return false;
                    }
                }
                freq.merge(hand[i], -1, Integer::sum);
            }
        }

        return true;
    }
}
