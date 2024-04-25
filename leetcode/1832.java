class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;
        int[] map = new int[26];
        for (int i = 0; i < sentence.length(); i++) 
            map[sentence.charAt(i)-'a']++;
        int i = 0;
        while (i < 26) {
            if (map[i] == 0)
                return false;
            i++;
        }
        return true;
    }
}