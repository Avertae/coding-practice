class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        boolean reverse = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                reverse = !reverse;
                continue;
            }
            if (reverse) sb.insert(0, s.charAt(i));
            else sb.append(s.charAt(i));
        }
        if (reverse)
            sb.reverse();
        return sb.toString();
    }
}