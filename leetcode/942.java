class Solution {
    public int[] diStringMatch(String s) {
        int lo = 0, hi = s.length(), pos = 0;
        int[] result = new int[hi + 1];
        // 3ms
        /*while (pos < s.length()) {
            if (s.charAt(pos) == 'I') 
                result[pos] = lo++;
            else
                result[pos] = hi--;
            pos++;
        }
        result[pos] = lo;*/

        // 2ms
        for (char c : s.toCharArray()) {
            if (c == 'I') 
                result[pos] = lo++;
            else
                result[pos] = hi--;
            pos++;
        }
        result[pos] = lo; 

        return result;
    }
}