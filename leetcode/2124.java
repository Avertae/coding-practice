class Solution {
    void dbg(Object... s) { Arrays.stream(s).forEach(z->System.out.print(z + ", ")); System.out.println();}
    public boolean checkString(String s) {
        boolean change = false;
        for (char c : s.toCharArray()) {
            if (change && c != 'b') return false;
            else if (c == 'b') change = true;
        }
        return true;
    }
}