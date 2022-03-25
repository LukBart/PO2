public class StackUtils {
    public static <T> String toString (Stack<T> o){
        String out = "[" + o.get(o.getCurrentSize() - 1);
        for (int i = o.getCurrentSize() - 2; i >= 0; i--){
            out += ", " + o.get(i);
        }
        out += "]";
        return out;
    }

    public static <T1, T2> boolean equals(Stack<T1> o1, Stack<T2> o2){
        return o1.equals(o2);
    }

    public static <T> Stack<T> swap(Stack<T> o, int index1, int index2) {
        if (index1 < 0 || index2 < 0){
            System.out.println("Given indexes are below zero");
            return null;
        }
        if (index1 >= o.getMaxSize() || index2 >= o.getMaxSize()){
            System.out.println("Given indexes are greater than stack max size");
            return null;
        }
        if (index1 > o.getCurrentSize() || index2 > o.getCurrentSize()){
            System.out.println("Given indexes are greater than current stack size");
            return null;
        }
        Object tmp1 = o.get(index1);
        Object tmp2 = o.get(index2);
        o.set(index2, tmp1);
        o.set(index1, tmp2);
        return o;
    }
}
