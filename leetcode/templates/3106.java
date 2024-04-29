class Solution {
    public String getSmallestString(String s, int k) {
        char[] cc = s.toCharArray();
        int i = 0;
        while (k > 0 && i < cc.length) {
            char c = cc[i];
            int dist = Math.min(c - 'a', (26 - c + 'a') % 26);
            if (k >= dist) {
                cc[i] = 'a';
                k -= dist;
            } else {
                cc[i] = (char)Math.min(c - k, (c + k - 'a') % 26 + 'a');
                //dbg(k, (c - k - 'a'), ((c + k - 'a') % 26 + 'a'));
                k = 0;
            }
            i++;
        }
        return new String(cc);
    }

}