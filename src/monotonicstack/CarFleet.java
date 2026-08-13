package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        // Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (int[] pair : pairs) {
            double time = (double) (target - pair[0]) / pair[1];

            // while(!stack.isEmpty() && stack.peek() <= time) {
            // stack.pop();
            // }
            // stack.push(time);
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();

    }
}
