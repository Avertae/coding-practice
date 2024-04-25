class Solution {
    public int countKeyChanges(String s) {
        String upper = s.toUpperCase();
        int result = 0; 
        char cur = upper.charAt(0);
        for (int i = 1; i < upper.length(); i++)
            if (upper.charAt(i) != cur) {
                result++;
                cur = upper.charAt(i);
            }
        return result;
    }
}