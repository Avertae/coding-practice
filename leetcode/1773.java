class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int data_idx;
        switch (ruleKey) {
            case "type": data_idx = 0; break;
            case "color": data_idx = 1; break;
            default: data_idx = 2;
        }
        // 3-4ms
        int result = 0;
        for (List<String> item : items)
            if (ruleValue.equals(item.get(data_idx))) result++;
        return result;

        // 4ms
        //return (int)items.stream().filter(s -> ruleValue.equals(s.get(data_idx))).count();

    }
}