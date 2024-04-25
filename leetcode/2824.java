class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size(), result = 0;
        //int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();  // 3ms
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) 
                //if (arr[i]+arr[j] < target) result++; 
                if (nums.get(i)+nums.get(j) < target) result++; // 2ms
        return result;
    }
}