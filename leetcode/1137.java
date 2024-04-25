class Solution {

    public int tribonacci(int n) {
        int[] trib = new int[n > 2 ? n+1 : 3];
        trib[0] = 0;
        trib[1] = 1;
        trib[2] = 1;
        if (n > 2)
            for (int i = 3; i <= n; i++)
                trib[i] = trib[i-3] + trib[i-2] + trib[i-1];
        return trib[n];
    }
}