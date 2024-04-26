class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length, sum = 0, lsum = 0, rsum;
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            sum += nums[i];
        rsum = sum - nums[0];
        result[0] = rsum;
        for (int i = 1; i < n; i++) {
            lsum += nums[i-1];
            rsum -= nums[i];
            result[i] = Math.abs(lsum-rsum);
        }
        return result;
    }
}