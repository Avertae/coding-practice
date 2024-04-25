class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int y = x, z = 0;
        while (y > 0) {
            z += y % 10;
            y = y / 10;
        }
        return (x % z == 0) ? z : -1;
    }
}