class Solution {
    public int pivotInteger(int n) {
        double sqrt = Math.sqrt(n*(n+1)/2);
        int isqrt = (int)Math.round(sqrt);
        return Math.abs(sqrt - isqrt) < 0.0000001 ? isqrt : -1;
    }

}