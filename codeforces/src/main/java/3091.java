class Solution {

    public int minOperations(int k) {
        int root = (int)Math.ceil(Math.sqrt(k)), min = 1000;
        for (int i = Math.max(1, root - 1); i <= root; i++) 
            min = Math.min(min, i - 2 + (k / i) + (k % i > 0 ? 1 : 0));
        return min;
    }
}