class Solution {

    int binary(int[] arr, int left, int right) {
        if (right < left || right - left == 1) return arr[right] > arr[left] ? right : left;
        if (right == left) return right;
        int mid = left + (right - left) / 2;
        if (mid-1 < 0 || 
                mid + 1 >= arr.length ||
                arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) 
            return mid;
        if (arr[mid] > arr[mid-1]) return binary(arr, mid+1, right);
        else return binary(arr, left, mid-1);
    }


    public int peakIndexInMountainArray(int[] arr) {
        return binary(arr, 0, arr.length - 1);
    }
}