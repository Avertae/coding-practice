class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        //for (int i = 0; i < goal.length(); i++) 
            //if (goal.equals(s.substring(i) + s.substring(0, i))) return true;
        return new String(s+s).contains(goal);
    }
}