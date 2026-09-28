package heap;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1)
            return stones[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int x : stones) {
            heap.offer(x);
        }

        while (!heap.isEmpty() && heap.size() > 1) {
            int y = heap.poll();
            int x = heap.poll();

            int res = y - x;
            if (res == 0)
                continue;
            else
                heap.offer(res);
        }

        if (heap.isEmpty())
            return 0;

        return heap.poll();

    }
}
