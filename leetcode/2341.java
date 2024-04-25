class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] map = new int[101], result = new int[2];
        for (int i : nums)
            map[i]++;
        for (int i : map) {
            result[0] += i / 2;
            result[1] += i % 2;
        }
        return result;
    }
}