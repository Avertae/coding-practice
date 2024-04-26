class Solution {
    public int countElements(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, 
            minamt = 0, maxamt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxamt = 1;
            } else if (nums[i] == max) 
                maxamt++;
            if (nums[i] < min) {
                min = nums[i];
                minamt = 1;
            } else if (nums[i] == min) 
                minamt++;
        }
        int result = n - maxamt - minamt;
        return result < 0 ? 0 : result;
    }
}