class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] forward = new int[n], reverse = new int[n];
        int forwardMul = 1, reverseMul = 1;
        for (int i = 0; i < n - 1; i++) {
            int j = n - i - 1;
            forwardMul *= nums[i];
            forward[i] = forwardMul;
            reverseMul *= nums[j];
            reverse[j] = reverseMul;
        }
        int[] result = new int[n];
        result[0] = reverseMul;
        result[n - 1] = forwardMul;
        for (int i = 1; i < n - 1; i++) {
            result[i] = forward[i - 1] * reverse[i + 1];
        }
        return result;
    }

}
