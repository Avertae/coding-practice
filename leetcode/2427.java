class Solution {
    public int commonFactors(int a, int b) {
        int result = 0;
        if (a == b) result++;
        if (a == 1) return result;
        else result++;
        int max = Math.max(a, b);
        for (int i = 2; i <= max / 2; i++)
            if (a % i == 0 && b % i == 0) result++;
        return result;
    }
}