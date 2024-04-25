class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length, max1 = -1, max2 = -2, maxIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                maxIdx = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        if (max2 == 0 || max1 / max2 >= 2) return maxIdx;
        else return -1;
    }
}