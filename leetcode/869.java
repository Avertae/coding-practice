class Solution {

    public boolean reorderedPowerOf2(int n) {
        int x = 1, y, namt = 0, amt;
        y = n;
        int[] ndigits = new int[10], digits = new int[10];
        while (y > 0) {
            ndigits[y % 10]++;
            y /= 10;
            namt++;
        }
        //dbg(namt, ndigits);
        outer:
        while (x < 1_000_000_000) {
            Arrays.fill(digits, 0);
            y = x;
            amt = 0;
            while (y > 0) {
                digits[y % 10]++;
                y /= 10;
                amt++;
            }
            x <<= 1;
            //dbg(amt, digits);
            if (amt != namt) continue;
            for (int i = 0; i < 10; i++) {
                if (digits[i] != ndigits[i])
                    continue outer;
            }
            
            return true;
        
        }
        return false;

    }

}