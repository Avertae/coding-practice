class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length, sum = nums[0] + nums[1], amt = 1;
        for (int i = 2; i < n - 1; i+=2)
            if (nums[i] + nums[i+1] == sum) amt++;
            else break;
        return amt;
    }

}