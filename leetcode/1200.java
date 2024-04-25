class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = 2000002, n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff > 0 && diff < min)
                min = diff;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 1; i++)
            if (arr[i + 1] - arr[i] == min)
                result.add(List.of(arr[i], arr[i + 1]));
        return result;
    }
}