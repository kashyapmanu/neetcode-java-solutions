class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int tank = 0;
            boolean ok = true;
            for (int steps = 0; steps < n; steps++) {
                int j = (start + steps) % n;
                tank += gas[j] - cost[j];
                if (tank < 0) {
                    ok = false;
                }
            }
            if (ok)
                return start;
        }
        return -1;
    }
}
