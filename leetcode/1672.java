class Solution {
    public int maximumWealth(int[][] accounts) {
        // 0ms
        int n = accounts.length, m = accounts[0].length, max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++)
                sum += accounts[i][j];
            if (sum > max) 
                max = sum;
        }
        return max;
        // 4ms
        /*return IntStream
                .range(0, accounts.length)
                .map(i -> IntStream
                        .range(0, accounts[i].length)
                        .map(j -> accounts[i][j])
                        .sum()
                )
                .max().getAsInt();*/
    }
}