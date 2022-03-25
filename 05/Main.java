public class Main {
    public static void main(String[] args) {
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
        System.out.println(c1); // 2.5 + 13.1i
        System.out.println(c2); // -8.5 - 0.9i
        System.out.println(new Complex(4.5)); // 4.5
        System.out.println(new Complex()); // 0.0
        System.out.println(new Complex(0., 5.1)); // 5.1i
        System.out.println();

        System.out.println("Adding (normal implementation):");
        System.out.println("c1 + c2 = " + ComplexOperations.add(c1, c2)); // c1 + c2 = -6.0 + 12.2i

        System.out.println("Subtract (anonymous class)");
        System.out.println("c1 - c2 = " + ComplexOperations.subtract(c1, c2)); // c1 - c2 = 11.0 + 14.0i

        System.out.println("Multiply (lambda):");
        System.out.println("c1 * c2 = " + ComplexOperations.multiply(c1, c2)); // c1 * c2 = -9.46 - 113.6i

        System.out.println("Divide (your choice):");
        System.out.println("c1 / c2 = " + ComplexOperations.divide(c1, c2)); // c1 / c2 = -0.4522310429783739 -
                                                                             // 1.4932931836846426i
    }
}
