class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int idx = Arrays.binarySearch(nums, target);
        int start = idx;
        if (idx < 0) return new ArrayList<Integer>();
        while (start > 0 && nums[start-1] == nums[idx]) start--;
        int end = idx;
        while (end < nums.length-1 && nums[end+1] == nums[idx]) end++;
        
        // 3ms
        List<Integer> result = new ArrayList<>(end - start + 1);
        for (int i = start; i <= end; i++) result.add(i);
        return result;
        // 4ms
        //return IntStream.range(start, end + 1).boxed().collect(Collectors.toList());
    }
}