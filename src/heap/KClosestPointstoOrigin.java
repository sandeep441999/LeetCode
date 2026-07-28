package heap;

import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // Map<Long, List<int[]>> map = new TreeMap<>();

        // for(int[] x : points) {
        // long val = 1L*x[0]*x[0] + 1L*x[1]*x[1];
        // map.computeIfAbsent(val, key -> new ArrayList<>()).add(x);
        // }
        int[][] res = new int[k][2];
        // int i=0;
        // for(List<int[]> arr : map.values()) {
        // for(int[] x : arr) {
        // res[i++] = x;
        // if(i==k) return res;
        // }
        // }
        // return res;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));

        for (int[] x : points) {
            heap.offer(x);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    public int distance(int[] x) {
        return x[0] * x[0] + x[1] * x[1];
    }
}
