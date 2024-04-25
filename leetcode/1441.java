class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int idx = 0; 
        for (int i : target) {
            for (int j = idx; j < i; j++) {
                if (j != idx) result.add("Pop");
                result.add("Push");
            }
            idx = i;
        }
        return result;
    }
}