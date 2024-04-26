class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length, idx1 = 0, idx2 = 0;
        int[] tmp = new int[n];
        tmp[0] = nums[1];
        for (int i = 2; i < n; i++) {
            if (nums[idx1] > tmp[idx2]) {
                idx1++;
                nums[idx1] = nums[i];
            } else {
                idx2++;
                tmp[idx2] = nums[i];
            }
        }
        idx1++;
        for (int i = 0; i <= idx2; i++) 
            nums[idx1+i] = tmp[i];
        return nums;
    }


}