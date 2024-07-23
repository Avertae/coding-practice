class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> struct = new HashMap<>();
        int max = 0, last = -1, n = s.length();
        if (n == 1) 
            return 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            Integer prev = struct.put(c, i);
            if (prev != null) {
                last = Math.max(last, prev);
            }
            max = Math.max(max, i - last);
            //dbg(max, i, last);
        }
        return max;
    }


    
void dbg(Object... s){ var o=System.out; int SIZE=20;
    for(Object z:s){
             if(z instanceof int[]){o.print("[");Arrays.stream((int[])z).limit(SIZE).forEach(x->o.print(x+","));if (((int[])z).length > 10) o.print("...");o.print("] ");}
        else if(z instanceof char[]){o.print("[[ch] "+new String((char[])z)+"] ");o.print("] ");}
        else if(z instanceof boolean[]){o.print("[[bool]");boolean[] bb=(boolean[])z;IntStream.range(0,Math.min(SIZE,bb.length)).mapToObj(i->bb[i]?'t':'f').forEach(o::print);o.print("] ");}
        else if(z instanceof Map){o.print("{");((Map)z).keySet().stream().limit(SIZE).map(k->k+"->"+((Map)z).get(k)+",").forEach(o::print);o.print("} ");}
        else o.print(z+", ");
    }
    o.println();}
}
