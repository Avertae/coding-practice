class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int quart = arr.length / 4;

        // 2ms
        /*int[] map = new int[100001];
        for(int i : arr) {
            map[i]++;
            if (map[i] > quart)
                return i;
        }
        return 0;*/

        // 2ms
        int maxAmt = 0, curAmt = 0, cur = -1;
        Arrays.sort(arr);
        for(int i : arr) {
            if (cur != i) {
                curAmt = 0;
                cur = i;
            }
            curAmt++;
            if (curAmt > quart) {
                return i;
            }
        }
        return 0;
    }
}