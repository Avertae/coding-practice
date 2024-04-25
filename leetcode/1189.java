class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] map = new int[5];
        for(int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'a': map[0]++; break;
                case 'b': map[1]++; break; 
                case 'l': map[2]++; break; 
                case 'n': map[3]++; break; 
                case 'o': map[4]++; break;
                default: // noop
            }
        }
        map[2] /= 2;
        map[4] /= 2;
        int min = 10000;
        for (int i = 0; i < 5; i++)
            if (map[i] < min)
                min = map[i];
        return min;
    }
}