class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Store the position and speed together
        int[][] car = new int[n][2];
        for (int i = 0; i < n; i++) {
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }

        // Sort the car by the descending order of their position
        Arrays.sort(car, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        Deque<Double> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            double time = (double) (target - car[i][0]) / car[i][1];

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
