class Solution {
    public int maximumCount(int[] nums) {
        int zero = Arrays.binarySearch(nums, 0);
        int neg, pos;
        if (zero >= 0) {
            int zeroleft = zero, zeroright = zero;
            while (zeroleft - 1 >= 0 && nums[zeroleft - 1] == 0) zeroleft--;
            while (zeroright + 1 < nums.length && nums[zeroright + 1] == 0) zeroright++;
            neg = zeroleft;
            pos = nums.length - zeroright - 1;
            System.out.println(zero + " " + zeroleft +" "+ zeroright+" "+  neg+" "+ pos);
        } else if (-zero >= nums.length) return nums.length;
        else if (nums[-zero] < 0) {
            neg = -zero;
            pos = nums.length - neg;
        } else {
            neg = -zero - 1;
            pos = nums.length - neg;
        }
        return Math.max(neg, pos);
    }
}