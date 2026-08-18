package design;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {
    // Set<int[]> cordinates;
    // Map<String, Integer> counts;
    Map<Integer, Map<Integer, Integer>> counts;

    public DetectSquares() {
        // cordinates = new HashSet<>();
        counts = new HashMap<>();
    }

    public void add(int[] point) {
        // cordinates.add(point);
        // String key = point[0] + "-" + point[1];
        // counts.merge(key, 1, Integer::sum);

        counts.computeIfAbsent(point[0], k -> new HashMap<>()).merge(point[1], 1, Integer::sum);

    }

    public int count(int[] point) {
        int px = point[0], py = point[1];
        int sum = 0;
        // for(int[] cordinate : cordinates) {
        // int x = cordinate[0], y = cordinate[1];
        // if(x == px || y == py || Math.abs((px-x)) != Math.abs((py-y))) continue;
        // sum += counts.getOrDefault(x + "-" + py, 0) * counts.getOrDefault(px + "-" +
        // y, 0);
        // }
        if (!counts.containsKey(px))
            return 0;

        for (Map.Entry<Integer, Integer> entry : counts.get(px).entrySet()) {
            int y = entry.getKey();
            int count = entry.getValue();

            if (y == py)
                continue;

            int side = Math.abs(y - py);

            int rightX = px + side;
            sum += count * counts.getOrDefault(rightX, new HashMap<>()).getOrDefault(y, 0)
                    * counts.getOrDefault(rightX, new HashMap<>()).getOrDefault(py, 0);

            int leftX = px - side;
            sum += count * counts.getOrDefault(leftX, new HashMap<>()).getOrDefault(y, 0)
                    * counts.getOrDefault(leftX, new HashMap<>()).getOrDefault(py, 0);
        }
        return sum;
    }
}
