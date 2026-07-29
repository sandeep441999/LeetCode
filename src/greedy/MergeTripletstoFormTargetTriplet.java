package greedy;

import java.util.HashSet;

public class MergeTripletstoFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // boolean found = false;
        // List<int[]> arr = new ArrayList<>();

        // for(int[] x : triplets) {
        // boolean add = true;
        // for(int i=0; i<3; i++) {
        // if(target[i] < x[i]) add = false;
        // }
        // if(add) arr.add(x);
        // }
        // for(int i=0; i<3; i++) {
        // found = false;
        // for(int j=0; j<arr.size(); j++) {
        // if(target[i] == arr.get(j)[i]) found = true;
        // }
        // if(!found) return false;
        // }

        // return found;

        HashSet<Integer> set = new HashSet<>();
        for (int[] x : triplets) {
            if (x[0] > target[0] || x[1] > target[1] || x[2] > target[2])
                continue;
            int i = 0;
            for (int t : x) {
                if (t == target[i])
                    set.add(i);
                i++;
            }
        }

        return set.size() == 3;
    }
}
