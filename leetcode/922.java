class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length, oi = 0, ei = 0;
        int[] result = new int[n];
        for (int i = 0; i < n / 2; i++) {
            while (nums[oi] % 2 == 0) oi++;
            while (nums[ei] % 2 == 1) ei++;
            result[2*i] = nums[ei++];
            result[2*i+1] = nums[oi++];
        }
        return result;
    }
}