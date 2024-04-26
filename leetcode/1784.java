class Solution {
    public boolean checkOnesSegment(String s) {
        boolean found = false;
        for(char c : s.toCharArray()) {
            if (found) { if (c != '0') return false; }
            else if (c == '0') found = true;
        }
        return true;
    }

}