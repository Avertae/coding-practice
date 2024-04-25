class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int i : nums) {
            int digits = 0;
            for (int j = i; j > 0; j /= 10)
                digits++;  
            if (digits % 2 == 0)
                result++;
        }
        return result;
    }
}