package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        List<String> itinery = new LinkedList<>();

        dfs("JFK", graph, itinery);

        return itinery;
    }

    public void dfs(String source, Map<String, PriorityQueue<String>> graph, List<String> itinery) {
        PriorityQueue<String> stops = graph.get(source);
        while (stops != null && !stops.isEmpty()) {
            dfs(stops.poll(), graph, itinery);
        }
        itinery.addFirst(source);
    }
}
