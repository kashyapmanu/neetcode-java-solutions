class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int sl = 0;
        for (int num: nums) {
            int counter = 1;
            if (!set.contains(num-1)) {
                while(set.contains(num+1)) {
                    counter+=1;
                    num+=1;
                }
            }
            sl = Math.max(sl, counter);
        }
        return sl;
    }
}
