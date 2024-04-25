class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int mod = n % 2;
        int div = n / 2;
        for (int i = n / 2; i > 0; i--) {
            result[div - i] = -i;
            result[div + i + mod - 1] = i;
        }
        return result;
    }
}