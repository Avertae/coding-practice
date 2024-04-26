class Solution {
    public boolean isThree(int n) {
        boolean found = false;
        if (n < 4) return false;
        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0) {
                if (found) return false;
                found = true;
            }
        return found;
    }
}