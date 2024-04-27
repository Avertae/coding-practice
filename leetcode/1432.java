class Solution {
    public int maxDiff(int num) {
        String snum = String.valueOf(num);
        int max, min, n = snum.length(), i;
        i = 0;
        while (i < n && snum.charAt(i) == '9') {
            i++;
        }
        if (n == i) 
            max = num;
        else 
            max = Integer.parseInt(snum.replaceAll(String.valueOf(snum.charAt(i)), "9"));

        char z = snum.charAt(0);
        boolean allSame = true;
        for (char x : snum.toCharArray())
            if (x != z) {
                allSame = false;
                break;
            }
        String replace = "0";
        i = 0;
        if (allSame) {
            replace = "1";
        } else {
            if (snum.charAt(0) == '1') {
                while (i < n && (snum.charAt(i) == '1' || snum.charAt(i) == '0')) {
                    i++;
                }
            }
        }
        if (i == 0)
            replace = "1";
        if (n == i)
            min = num;
        else 
            min = Integer.parseInt(snum.replaceAll(String.valueOf(snum.charAt(i)), replace));
        return max - min;
    }

}