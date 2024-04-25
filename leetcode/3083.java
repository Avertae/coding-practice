class Solution {
    public boolean isSubstringPresent(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            String sub = new StringBuilder(s.substring(i, i+2))
                    .reverse()
                    .toString();
            if (s.indexOf(sub)>= 0)
                return true;
        }
        return false;
    }
}