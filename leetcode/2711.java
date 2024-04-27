class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        int[][] result = new int[m][n];
        // 10ms
        /*for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) {
                int k = 1;
                set.clear();
                while (i - k >= 0 && j - k >= 0) {
                    set.add(grid[i - k][j - k]);
                    k++;
                }
                int tl = set.size();
                k = 1;
                set.clear();
                while (i + k < m && j + k < n) {
                    set.add(grid[i + k][j + k]);
                    k++;
                }
                //dbg(i, j, tl, set.size());
                result[i][j] = Math.abs(tl - set.size());
            }*/

        // 6ms
        for (int i = -n; i < m; i++) {
            set.clear();
            for (int j = 0; j < n; j++) {
                if (i + j < 0) continue;
                if (i + j >= m) break;
                result[i + j][j] = set.size();
                set.add(grid[i + j][j]);
            }
            //dbg(set.size());
            set.clear();
            for (int j = n - 1; j >= 0; j--) {
                if (i + j < 0) break;
                if (i + j >= m) continue;
                result[i + j][j] = Math.abs(result[i + j][j] - set.size());
                set.add(grid[i + j][j]);
            }
            //dbg(set.size());
        }
        return result;
    }

}