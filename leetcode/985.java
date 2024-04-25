class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0;
        int[] result = new int[n];
        for (int i : nums) 
            if (i % 2 == 0) sum += i;
        for (int i = 0; i < n; i++) {
            if (nums[queries[i][1]] % 2 == 0)
                sum -= nums[queries[i][1]];
            nums[queries[i][1]] += queries[i][0];
            if (nums[queries[i][1]] % 2 == 0) 
                sum += nums[queries[i][1]];
            result[i] = sum;
        }
        return result;
    }
}