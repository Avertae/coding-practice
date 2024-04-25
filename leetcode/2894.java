class Solution {
    public int differenceOfSums(int n, int m) {
        int sum = n*(n+1)/2;
        int msum = (n/m)*(m + n-(n%m));
        return sum - msum;
    }
}