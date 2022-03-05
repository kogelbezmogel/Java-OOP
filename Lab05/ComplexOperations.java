public class ComplexOperations {

    public static Complex add(Complex c1, Complex c2) {
        class Temp implements ComplexFunction {
            public Complex calculate (Complex c1, Complex c2) {
                return new Complex(c1.x + c2.x, c1.y + c2.y);
            }
        }
        Temp add = new Temp();
        return calculate(c1, c2, add);
    }

    public static Complex subtract(Complex c1, Complex c2) {
        ComplexFunction subtract = new ComplexFunction() {
            public Complex calculate (Complex c1, Complex c2) {
                return new Complex(c1.x - c2.x, c1.y - c2.y);
            }
        };
        return calculate(c1, c2, subtract);
    }

    public static Complex multiply(Complex c1, Complex c2) {
        
        ComplexFunction multiply = (Complex b1, Complex b2) -> { return new Complex( b1.x*b2.x - b1.y*b2.y,  b1.x*b2.y + b2.x*b1.y ); };

        return calculate(c1, c2, multiply);
    }

    public static Complex divide(Complex c1, Complex c2) {
        ComplexFunction divide = (Complex b1, Complex b2) -> {

            double d = Math.pow(b2.x, 2) + Math.pow(b2.y, 2);
            return new Complex ( (b1.x*b2.x + b1.y*b2.y) / d, (b2.x*b1.y - b1.x*b2.y) / d);
        };
        return calculate(c1, c2, divide);
    }

    private static Complex calculate(Complex c1, Complex c2, ComplexFunction function) {
        return function.calculate(c1, c2);
    }
}
