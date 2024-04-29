class Solution {

    public int surfaceArea(int[][] grid) {
        // top+bottom -> non-zeros count * 2
        // from sides -> sum += a-b

        int n = grid.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (val != 0) sum++;
                if (i == 0)
                    sum += val;
                else {
                    int prevVal = grid[i - 1][j];
                    if (val > prevVal) sum += val - prevVal;
                }
                if (j == 0)
                    sum += val;
                else {
                    int prevVal = grid[i][j - 1];
                    if (val > prevVal) sum += val - prevVal;
                }
            }
        }
        return sum*2;
    }

}