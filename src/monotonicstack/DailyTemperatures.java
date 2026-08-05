package monotonicstack;

import java.util.ArrayDeque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
