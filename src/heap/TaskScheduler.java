package heap;

// import java.util.ArrayDeque;
// import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // int[] freq = new int[26];
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) ->
        // Integer.compare(b, a));

        // for (char c : tasks) {
        // freq[c - 'A']++;
        // }

        // for (int c : freq) {
        // if (c > 0) {
        // maxHeap.offer(c);
        // }
        // }
        // int time = 0;
        // ArrayDeque<int[]> q = new ArrayDeque<>();

        // while (!q.isEmpty() || !maxHeap.isEmpty()) {
        // time++;

        // if (!maxHeap.isEmpty()) {
        // int count = maxHeap.poll() - 1;

        // if (count > 0) {
        // q.offer(new int[] { count, time + n });
        // }
        // }

        // if (!q.isEmpty() && q.peek()[1] == time) {
        // maxHeap.offer(q.poll()[0]);
        // }

        // }

        // return time;

        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        int maxFreq = 0;
        for (int c : freq) {
            maxFreq = Math.max(maxFreq, c);
        }

        int maxCount = 0;

        for (int c : freq) {
            if (c == maxFreq) {
                maxCount++;
            }
        }

        int time = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, time);
    }
}
