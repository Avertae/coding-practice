class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE, n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int sum = nums[i] + nums[n-i-1];
            if (sum > max) 
                max = sum;
        }
        return max;
    }
}