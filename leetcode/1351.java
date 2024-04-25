class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, row = 0;
        while (row < m && grid[row][0] >= 0) row++;
        if (row == 0)
            return m*n;
        row--;
        int col = 1, count = m - row - 1;
        while (col < n && row >= 0) {
            //System.out.println(" row" + row + " col" + col );
            if (grid[row][col] >= 0) {
                col++;
                count += m - row - 1;
            }
            else 
                row--;
            //System.out.println(" count" + count);
        }
        count += (n - col) * m;
        return count;
    }
}