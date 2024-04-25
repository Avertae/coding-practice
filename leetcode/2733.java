class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length <= 2) return -1;
        int max = 0, min = 101;
        for (int i = 0; i < 3; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        int i = 0;
        while (nums[i] == max || nums[i] == min) i++;
        return nums[i];
    }
}