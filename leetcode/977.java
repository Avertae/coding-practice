class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i]*nums[i];
        Arrays.sort(nums);
        return nums; // 7ms
        //return Arrays.stream(nums).map(i -> i*i).sorted().toArray();   // 11ms
    }
}