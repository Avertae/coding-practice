class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i = 0; int j = nums.length - 1;
        while (i < j && nums[i] < 0 && nums[j] > 0) {
            if (nums[i]+nums[j] == 0) return nums[j];
            if (nums[i]+nums[j] < 0) i++;
            else j--;
        }
        return -1;
    }
}