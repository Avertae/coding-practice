class Solution {
    public char repeatedCharacter(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (freq[idx] == 1) return s.charAt(i);
            else freq[idx]++;
        }
        return 'a';
    }
}