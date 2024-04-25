class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 0;
        for(int i = 0; i < mat.length; i++) {
            int ones = 0;
            for(int j = 0; j < mat[i].length; j++) 
                if (mat[i][j] == 1) ones++;
            if (ones > result[1]) {
                result[0] = i;
                result[1] = ones;
            }
        }
        return result;
    }
}