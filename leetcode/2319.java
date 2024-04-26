class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if ((grid[i][j] == 0) == (i == j || i == n - 1 - j))
                    return false;
        return true;
    }
}

