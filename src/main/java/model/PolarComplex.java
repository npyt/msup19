package model;

public class PolarComplex extends ComplexNumber {

    private double module;
    private double argument;

    public PolarComplex(double module, double argument) {
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

    public double getModule() {
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
