class Solution {
    public int sumOfSquares(int[] nums) {
        int result = 0, n = nums.length;
        for (int i = 1; i < n/2; i++) {
            if (n % (i+1) == 0)
                result += nums[i]*nums[i];
        }
        if (n>1)
            result += nums[n-1]*nums[n-1];
        return result + nums[0]*nums[0];
    }
}