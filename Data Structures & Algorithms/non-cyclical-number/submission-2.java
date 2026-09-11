class Solution {
    public boolean isHappy(int n) {
        /*
         - Loop and deconstrucut the number to get the sum of the squares of its digits.
         - Keep replacing the number with the sum till the number becomes 1 or it starts looping.
        */
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                int m = n % 10;
                sum += m * m;
                n = n / 10;
            }
            n = sum;
            if (n == 1)
                return true;
            if (set.contains(n))
                return false;
            set.add(n);
        }
    }
}
