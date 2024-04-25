class Solution {
    public int subtractProductAndSum(int n) {
        int result = 1, sum = 0;
        for(int i = n; i > 0; i /= 10) {
            result *= i % 10;
            sum += i % 10;
        }
        return result - sum;
    }
}