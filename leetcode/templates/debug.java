
void dbg(Object... s){ var o=System.out; int SIZE=20;
    for(Object z:s){
             if(z instanceof int[]){o.print("[");Arrays.stream((int[])z).limit(SIZE).forEach(x->o.print(x+","));if (((int[])z).length > 10) o.print("...");o.print("] ");}
        else if(z instanceof char[]){o.print("[[ch] "+new String((char[])z)+"] ");o.print("] ");}
        else if(z instanceof boolean[]){o.print("[[bool]");boolean[] bb=(boolean[])z;IntStream.range(0,Math.min(SIZE,bb.length)).mapToObj(i->bb[i]?'t':'f').forEach(o::print);o.print("] ");}
        else if(z instanceof Map){o.print("{");((Map)z).keySet().stream().limit(SIZE).map(k->k+"->"+((Map)z).get(k)+",").forEach(o::print);o.print("} ");}
        else o.print(z+", ");
    }
    o.println();}
