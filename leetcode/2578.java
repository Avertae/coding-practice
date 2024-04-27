
class Solution {
    public int splitNum(int num) {
        char[] cnum = String.valueOf(num).toCharArray();
        Arrays.sort(cnum);
        StringBuilder sb = new StringBuilder(), sb2 = new StringBuilder();
        for (int i = 0; i < cnum.length; i++)
            if (i % 2 == 0) sb.append(cnum[i]);
            else sb2.append(cnum[i]);
        int num1 = Integer.parseInt(sb.toString());
        int num2 = Integer.parseInt(sb2.toString());
        return num1+num2;
    }
}

