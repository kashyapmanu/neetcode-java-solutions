class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Number of cars
        int n = position.length;

        // Store the cards starting position with its speed
        int[][] car = new int[n][2];
        for (int i = 0; i < n; i++) {
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }

        // Sort the car by the descending value of position
        Arrays.sort(car, (a, b) -> b[0] - a[0]);

        // Calculate the arrival time of each car if nothing is blocking it.
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = (double) (target - car[i][0]) / car[i][1];
        }

        int fleet = 0;
        /*
        Now the cars are sorted in the descending order of thier position.
        We need to check one by one what is the max time it takes for the cars ahead
        of them to reach the target.
        If a car's time is lesser than than the other cars ahead of it i.e the car is
        slower compared to the cars ahead then it forms a new fleet.
        */
        for (int i = 0; i < n; i++) {
            double maxAheadTime = 0;
            for (int j = 0; j < i; j++) {
                maxAheadTime = Math.max(maxAheadTime, times[j]);
            }
            if (times[i] > maxAheadTime) {
                fleet++;
            }
        }

        return fleet;
    }
}
