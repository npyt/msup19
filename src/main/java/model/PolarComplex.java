package model;

/**
 * Representa la forma polar de un complejo
 */
public class PolarComplex extends ComplexNumber {

    private double modulus;
    private double argument;

    public PolarComplex(double modulus, double argument) {
    	this.modulus = modulus;
        this.argument = argument;
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
        double realPart = this.calculateRealPart();
        double imaginaryPart = this.calculateImaginaryPart();
    	
        return new RectangularComplex(realPart, imaginaryPart);
    }

    PolarComplex toPolar() {
        return this;
    }
    
    public double calculateRealPart() {
    	double realPart = Math.cos(this.argument) * this.modulus;
    	
    	return realPart;
    }
    
    public double calculateImaginaryPart() {
    	double imaginaryPart = Math.sin(this.argument) * this.modulus;
    	
    	return imaginaryPart;
    }

    public double getModulus() {
    	return this.modulus;
    }

    public double getArgument() {
    	return this.argument;
    }

    public boolean isNullComplex() {
        return this.toRectangular().isNullComplex();
    }

    @Override
    public String toString() {
        return "[" + this.modulus + ", " + this.argument + "]";
    }
}
