class Solution {

    int lmax = 0, rmax = 0;
    String ss;

    // 1ms divide and conquer
    void dnc(int l, int r) {
        if (l >= r) return;
        for (int i = l; i < r; i++) {
            char c = ss.charAt(i);
            int idx = -1;
            if (Character.isLowerCase(c))
                idx = ss.indexOf(Character.toUpperCase(c), l ,r); 
            else 
                idx = ss.indexOf(Character.toLowerCase(c), l, r); 
            
            if (idx >= 0)
                continue;

            dnc(l, i);
            dnc(i + 1, r);
            return;
        }
        if (rmax - lmax < r - l) {
            rmax = r;
            lmax = l;
        }
    }

    public String longestNiceSubstring(String s) {
        ss = s;
        if (s.length() == 1) return "";
        dnc(0, s.length());
        return s.substring(lmax, rmax);
    }

    // 17ms
    /*boolean check(String s) {
        boolean[] lo = new boolean[26], hi = new boolean[26];
        for (char c : s.toCharArray()) 
            if ('a' <= c && c <= 'z') lo[c - 'a'] = true;
            else if ('A' <= c && c <= 'Z') hi[c - 'A'] = true;
        for (int i = 0; i < lo.length; i++)
            if (lo[i] != hi[i]) 
                return false;
        return true;
    }

    public String longestNiceSubstring(String s) {
        int n = s.length(), max = 0;
        String maxSub = "";
        for (int i = 0; i < n; i++) 
            for (int j = n; j > i; j--) {
                String sub = s.substring(i, j);
                if (check(sub) && j - i > max) {
                    max = j - i;
                    maxSub = sub;
                }
            }
        return maxSub;
    }*/

}