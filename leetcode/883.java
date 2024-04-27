class Solution {
    public int projectionArea(int[][] grid) {
        int xy = 0, yz = 0, xz = 0, n = grid.length;
        int max1;
        int[] max2 = new int[grid.length];
        
        // xy -> non-zero
        // yz -> max x axis
        // xz -> max y axis

        for (int i = 0; i < n; i++) {
            int[] row = grid[i];
            max1 = 0;
            for (int j = 0; j < n; j++) {
                max1 = Math.max(max1, row[j]);
                max2[j] = Math.max(max2[j], row[j]);
                if (row[j] > 0) xy++;
            }
            yz += max1;
        }
        for (int i : max2)
            xz += i;
        //dbg(xy, xz, yz);
        return xy+xz+yz;

    }

}