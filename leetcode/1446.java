class Solution {
    public int maxPower(String s) {
        int max = 1;
        char curChar = s.charAt(0);
        int curAmt = 1;
        for(int i = 1; i < s.length(); i++)
            if (s.charAt(i) == curChar) curAmt++;
            else {
                if (max < curAmt) max = curAmt;
                curAmt = 1;
                curChar = s.charAt(i);
            }
        if (max < curAmt) max = curAmt;            
        return max;
    }
}