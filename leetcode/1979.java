class Solution {

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int findGCD(int[] nums) {
        int n = nums.length, max = 0, min = 1000;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        return gcd(max, min);
    }
}