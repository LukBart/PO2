public class Main {
    public static void main(String[] args) {
        // Stack
        Stack<Double> stack = new Stack<>(2);

        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println();

        try {
            stack.pop();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        stack.push(10.);
        stack.push(10.);

        try {
            stack.push(10.);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        Stack<Double> stack2 = stack.copy();
        System.out.println(stack2.pop());
        System.out.println("Stack size: " + stack.getCurrentSize());
        System.out.println("Stack2 size: " + stack2.getCurrentSize());

        // StackUtils
        System.out.println();
        System.out.println(StackUtils.toString(stack));
        System.out.println(StackUtils.toString(stack2));
//
        System.out.println();
        Stack<Integer> stack3 = new Stack<>(2);
        stack3.push(10);
        System.out.println("stack2 equals stack3: " + StackUtils.equals(stack2, stack3));
        stack2.push(11.);
        System.out.println("stack2 equals stack: " + StackUtils.equals(stack2, stack));
        stack2.pop();
        stack2.push(10.);
        System.out.println("stack2 equals stack: " + StackUtils.equals(stack2, stack));

        System.out.println();
        Stack<Integer> swapStack = new Stack<>(10);
        for (int i = 0; i < 5; i++) {
            swapStack.push(i);
        }

        try {
            StackUtils.swap(swapStack, 10, 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            StackUtils.swap(swapStack, 2, 8);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            StackUtils.swap(swapStack, -1, 3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(StackUtils.toString(swapStack));
        swapStack = StackUtils.swap(swapStack, 1, 2);
        System.out.println(StackUtils.toString(swapStack));
    }
}
