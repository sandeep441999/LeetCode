package greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int n = gas.length;

        // for(int i=0; i<n; i++) {
        // int idx = i+1;
        // int cidx = i+1;
        // int visited = 1;
        // int g = gas[i];
        // if(gas[i]-cost[i] >= 0) {
        // int res = f(gas, cost, i, i+1, gas[i]-cost[i]);
        // if( res == -1) continue;
        // else return res;
        // }
        // }
        // return -1;

        int canDo = 0;

        int n = gas.length;

        for (int i = 0; i < n; i++) {
            canDo += gas[i] - cost[i];
        }
        if (canDo < 0)
            return -1;
        int start = 0;
        int tank = 0;

        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return start;

    }

    public int f(int[] gas, int[] cost, int start, int i, int g) {
        int n = gas.length;
        int rem = g - cost[i % n] + gas[i % n];
        if (rem < 0)
            return -1;
        if (start == i % n)
            return start;

        return f(gas, cost, start, (i + 1) % n, rem);
    }
}
