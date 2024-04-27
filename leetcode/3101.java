class Solution {
    public long countAlternatingSubarrays(int[] nums) {

        int strike = 1;
        long result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                strike = 1;
                result++;
            }
            else 
                result += ++strike;
            //dbg(result);
        }
            
        return result;

    }
void dbg(Object... s){
    var o=System.out;
    for(Object z:s){
        if(z instanceof int[]){
            o.print("[");
            Arrays.stream((int[])z).limit(10).forEach(x->o.print(x+","));
            if (((int[])z).length > 10) o.print("...");
            o.print("] ");
        }else if(z instanceof char[]){
            o.print("[[ch]" + new String((char[])z)+"] ");
            o.print("] ");
        } else if (z instanceof Map){
            o.print("{");
            ((Map)z).keySet().stream().limit(10).map(k->k+"->"+((Map)z).get(k)+",").forEach(o::print);
            o.print("} ");
        } else
            o.print(z+", ");
    }
    o.println();
}
}