class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for (int i : stones) queue.add(i);
        while (queue.size() > 1) {
            int x = queue.remove();
            int y = queue.remove();
            System.out.println(x + "vs" + y);
            if (x-y > 0) queue.add(x-y);
        }
        return queue.size() == 0 ? 0 : queue.remove();
    }
}