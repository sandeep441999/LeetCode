package sorting;

import java.util.List;

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return true;

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start)
                return false;
        }

        return true;
    }
}
