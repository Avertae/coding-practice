class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int[] map = new int[10001];
        for (int i = 0; i < n; i++) {
            map[nums[i]]++;
            if (map[nums[i]] > 1) return nums[i];
        }
        return -1;
    }
}