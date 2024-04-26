class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] map1 = new int[n+1];
        int[] map2 = new int[n+1];
        for (int[] t : trust) {
            map1[t[0]]++;
            map2[t[1]]++;
        }
        for (int i = 1; i <= n; i++)
            if (map1[i] == 0 && map2[i] == n - 1)
                return i;
        return -1;
    }
}