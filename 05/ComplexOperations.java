public class ComplexOperations {

    public static Complex add(Complex c1, Complex c2) {
        // tutaj kod
        class Add implements ComplexFunction {
            public Complex calculate(Complex c1, Complex c2){
                return new Complex (c1.getR() + c2.getR(), c1.getIm() + c2.getIm());
            }
        }

        ComplexFunction add = new Add ();
        return calculate(c1, c2, add);
    }

    public static Complex subtract(Complex c1, Complex c2) {
        // tutaj kod
        ComplexFunction subtract = new ComplexFunction(){
            public Complex calculate (Complex c1, Complex c2){
                return new Complex (c1.getR() - c2.getR(), c1.getIm() - c2.getIm());
            }
        }; 
        return calculate(c1, c2, subtract);
    }

    public static Complex multiply(Complex c1, Complex c2) {
        // tutaj kod 
        ComplexFunction multiply = (co1, co2) -> {
            return new Complex (co1.getR() * co2.getR() - co1.getIm() * co2.getIm(), co1.getR() * co2.getIm() + co1.getIm()* co2.getR());
        };
        return calculate(c1, c2, multiply);
    }

    public static Complex divide(Complex c1, Complex c2) {
        // tutaj kod
        class Divide implements ComplexFunction{
            public Complex calculate (Complex c1, Complex c2){
                return new Complex ((c1.getR()*c2.getR() + c1.getIm()*c2.getIm())/(Math.pow(c2.getR(), 2)+Math.pow(c2.getIm(), 2)),
                (c1.getIm()*c2.getR() - c1.getR()*c2.getIm())/(Math.pow(c2.getR(), 2)+Math.pow(c2.getIm(), 2)));
            }
        }

        ComplexFunction divide = new Divide();
        return calculate(c1, c2, divide);
    }

    private static Complex calculate(Complex c1, Complex c2, ComplexFunction function) {
        return function.calculate(c1, c2);
    }
}
