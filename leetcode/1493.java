class Solution {
    public int longestSubarray(int[] nums) {
        int prev = -1, serie = 0, prev_serie = 0, amt = 0, max = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                serie++;
            else {
                max = Math.max(prev_serie + serie, max);
                prev_serie = serie;
                serie = 0;
            } 
        }
        max = Math.max(max, prev_serie + serie);

        if (serie == nums.length)
            max = serie - 1;

        return max;
    }

}