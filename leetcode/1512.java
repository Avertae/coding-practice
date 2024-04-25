class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] map = new int[101];
        int n = nums.length, result = 0;
        for (int i = 0; i < n; i++)
            map[nums[i]]++;
        
        for (int i = 1; i < 101; i++) 
            if (map[i] > 1) result += (map[i]-1)*(map[i]) / 2;
        
        return result;
    }
}