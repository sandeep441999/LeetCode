package heap;

import java.util.List;
import java.util.PriorityQueue;

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
        heap.offer(intervals.get(0));

        for (int i = 1; i < n; i++) {
            Interval meet = heap.peek();
            if (meet.end > intervals.get(i).start) {
                heap.offer(intervals.get(i));
            } else if (meet.end == intervals.get(i).start) {
                heap.poll();
                heap.offer(intervals.get(i));
            } else {
                heap.poll();
                heap.offer(new Interval(Math.min(meet.start, intervals.get(i).start),
                        Math.max(meet.end, intervals.get(i).end)));
            }
        }

        return heap.size();
    }
}
