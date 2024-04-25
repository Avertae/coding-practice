class Solution {
    public int alternateDigitSum(int n) {
        int result = 0;
        while (n > 0) {
            result = n % 10 - result;
            n = n / 10;
        }
        return result;
    }
}