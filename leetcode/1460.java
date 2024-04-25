class Solution {

    public boolean quicksort(int[] target, int[] arr) { // 3ms
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++)
            if (target[i] != arr[i]) 
                return false;
        return true; 
    }

    public boolean memmap(int[] target, int[] arr) { // 10ms
        int[] memmap = new int[1001];
        for (int i = 0; i < target.length; i++) {
            memmap[target[i]]++;
            memmap[arr[i]]--;
        }
        System.out.println(Arrays.toString(memmap));
        for (int i = 0; i < target.length; i++) 
            if (memmap[target[i]] != 0 || memmap[arr[i]] != 0)
                return false;
        return true; 
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        return quicksort(target, arr);
    }
}