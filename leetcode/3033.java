class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> replace = new ArrayList(m);
        for (int i = 0; i < n; i++) {
            int max = -1;
            replace.clear();
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] > max)
                    max = matrix[j][i];
                if (matrix[j][i] == -1)
                    replace.add(j);
            }
            if (replace.size() > 0)
                for (int j : replace)
                    matrix[j][i] = max;
        }
        return matrix;
    }
}