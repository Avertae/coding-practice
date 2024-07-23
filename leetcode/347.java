class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums)
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        return freq.entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .limit(k)
            .mapToInt(e -> e.getKey())
            .toArray();
    }
}
