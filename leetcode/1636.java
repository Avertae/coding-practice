class Solution {
    public int[] frequencySort(int[] nums) {
        int[] map = new int[201];

        for(int i : nums) map[i+100]++;
        
        return Arrays.stream(nums)
            .boxed()
            .sorted((a, b) -> Integer.compare(b, a))
            .sorted((a, b) -> Integer.compare(map[a+100], map[b+100]))
            .mapToInt(i -> i)
            .toArray();
    }
}