package monotonicstack;

import java.util.ArrayDeque;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int max = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= heights.length; i++) {
            int currHeight = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                int height = heights[stack.pop()];
                int w;

                if (stack.isEmpty()) {
                    w = i;
                } else {
                    w = i - stack.peek() - 1;
                }
                max = Math.max(max, height * w);
            }
            stack.push(i);
        }

        return max;
    }
}
