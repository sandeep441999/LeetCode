package topologicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // if(prerequisites.length == 0) return true;
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        // for(int i=0; i<prerequisites.length; i++) {
        // map.put(prerequisites[i][0], prerequisites[i][1]);
        // }

        // Set<Integer> set;
        // List<Integer> res = new ArrayList<>();

        // for(int i=0; i<prerequisites.length; i++) {
        // int u = prerequisites[i][0];
        // int v = prerequisites[i][1];
        // if(map.containsKey(v)) {
        // boolean canAdd = false;
        // set = new HashSet<>();
        // List<Integer> visited = new ArrayList<>();
        // while(map.containsKey(v) && !visited.contains(v)) {
        // visited.add(v);
        // if(!set.contains(u)) set.add(u);
        // int temp = v;
        // v = map.get(v);
        // u = temp;
        // }
        // if(!map.containsKey(v)) canAdd = true;
        // if(canAdd) {
        // for(Integer x : set) {
        // res.add(x);
        // }
        // }
        // } else {
        // res.add(u);
        // res.add(v);
        // }
        // }
        // return res.size() == numCourses;

        // The above code doesn't work and we have to use below Khans Algo which BFS +
        // Topological Sort

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        for (int[] x : prerequisites) {
            graph.get(x[0]).add(x[1]);
            indegree[x[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (indegree[curr] == 0) {
                order[idx] = curr;
                idx++;
                for (int v : graph.get(curr)) {
                    if (--indegree[v] == 0)
                        q.offer(v);
                }
            }
        }
        return idx == numCourses ? true : false;
    }
}
