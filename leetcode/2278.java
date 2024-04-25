class Solution {
    public int percentageLetter(String s, char letter) {
        int amt = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == letter) amt++;
        return amt*100/s.length();
    }
}