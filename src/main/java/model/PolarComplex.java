package model;

/**
 * Representa la forma polar de un complejo
 */
public class PolarComplex extends ComplexNumber {

    private double modulus;
    private double argument;

    public PolarComplex(double modulus, double argument) {
        //TODO implementar
    }

    public ComplexNumber add(ComplexNumber z) {
        //TODO implementar
        return null;
    }

    public ComplexNumber subtract(ComplexNumber z) {
        //TODO implementar
        return null;
    }

    public ComplexNumber multiply(ComplexNumber z) {
        //TODO implementar
        return null;
    }

    public ComplexNumber divideBy(ComplexNumber z) {
        //TODO implementar
        return null;
    }

    public ComplexNumber conjugate() {
        //TODO implementar
        return null;
    }

    RectangularComplex toRectangular() {
        //TODO implementar
        return null;
    }

    PolarComplex toPolar() {
        return this;
    }

    public double getModulus() {
        //TODO implementar
        return 0;
    }

    public double getArgument() {
        //TODO implementar
        return 0;
    }

    public boolean isNullComplex() {
        //TODO implementar
        return false;
    }
}
