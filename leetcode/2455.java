class Solution {
    public int averageValue(int[] nums) {
        int result = 0, count = 0;
        for (int i : nums) 
            if (i % 2 == 0 && i % 3 == 0) {
                count++;
                result+=i;
            }
        return count == 0 ? 0 : result / count;
    }
}