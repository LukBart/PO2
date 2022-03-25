import java.util.Arrays;
import java.util.Objects;
import java.lang.RuntimeException;

public class Stack <T>{
    private T tab[];
    private int maxSize;
    private int currentSize;

    public Stack (int s){
        maxSize = s;
        @SuppressWarnings("unchecked")
        T[] data = (T[]) new Object[maxSize];
        this.tab = data;
        currentSize = 0;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize == maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public T pop(){
        if (currentSize != 0) {
            T o = tab[currentSize - 1];
            tab[currentSize- 1] = null;
            currentSize--;
            return o;
        }
        throw new RuntimeException("Stack is empty");
    }

    public void push(T newItem){
        if (currentSize < maxSize) {
            tab[currentSize] = newItem;
            currentSize++;
        }
        else{
            throw new RuntimeException("Stack is full");
        }
    }

    public Stack<T> copy(){
        Stack<T> newStack = new Stack<>(maxSize);
        for (int i = 0; i < currentSize; i++) {
            newStack.push(tab[i]);
        }
        return newStack;
    }

    public T get(int index){
        return tab[index];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stack)) return false;
        Stack<?> stack = (Stack<?>) o;
        return maxSize == stack.maxSize && currentSize == stack.currentSize && Arrays.equals(tab, stack.tab);
    }
    @SuppressWarnings("unchecked")
    public void set(int index, Object val){
        tab[index] = (T)val;
    }
}
