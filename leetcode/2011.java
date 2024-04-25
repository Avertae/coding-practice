class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String op : operations)
            if (op.indexOf('-') >= 0) result--;
            else result++;
        return result;
    }
}