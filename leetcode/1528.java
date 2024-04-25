class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(s.length());
        for (int i = 0; i < s.length(); i++) {
            sb.setCharAt(indices[i], s.charAt(i));
        }
        return sb.toString();
    }
}