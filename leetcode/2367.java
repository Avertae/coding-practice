class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length, amt = 0, diff1;
        for (int i = 0; i < n-2; i++) 
            for (int j = i+1; j < n-1; j++) 
                if (nums[j] - nums[i] == diff) {
                    for (int k = j+1; k < n; k++)
                        if (nums[k] - nums[j] == diff) {
                            amt++;
                            break;
                        }
                    break;
                }
        return amt;
    }
}