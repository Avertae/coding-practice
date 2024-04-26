
void dbg(Object... s){
    var o=System.out;
    Arrays.stream(s).forEach(
        z-> {
        if(z instanceof int[]){
            o.print("[");
            Arrays.stream((int[])z).limit(Math.min(((int[])z).length,10)).forEach(x->o.print(x+","));
            if (((int[])z).length > 10) o.print("...");
            o.print("] ");
        } else 
            o.print(z+", ");}
    );
    o.println();
}