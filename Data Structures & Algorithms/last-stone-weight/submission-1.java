class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0)
            return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int h1 = maxHeap.poll();
            int h2 = maxHeap.poll();
            if (h1 != h2) {
                maxHeap.offer(h1 - h2);
            }
        }
        return maxHeap.size() >= 1 ? maxHeap.poll() : 0;
    }
}
