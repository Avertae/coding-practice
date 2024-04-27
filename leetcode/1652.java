class Solution {
    public int[] decrypt(int[] code, int k) {
        int sum = 0, n = code.length;
        int[] result = new int[n];
        if (k != 0) {
            for(int i = 0; i < Math.abs(k); i++)
                sum += code[i];
            if (k > 0)
                for (int i = 2*n - 1; i > n - 1; i--) {
                    int idx = i % n, idx2 = (i + k) % n;
                    result[idx] = sum;
                    sum += code[idx] - code[idx2];
                }
            else {
                k = -k;
                for (int i = k; i < n + k; i++) {
                    int idx = i % n, idx2 = (i - k) % n;
                    result[idx] = sum;
                    sum += code[idx] - code[idx2];
                }
            }
        }
        return result;
    }
}