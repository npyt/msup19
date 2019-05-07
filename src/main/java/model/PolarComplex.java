package model;

/**
 * Representa la forma polar de un complejo
 */
public class PolarComplex extends ComplexNumber {

    private final double modulus;
    private final double argument;

    public PolarComplex(double modulus, double argument) {
    	this.modulus = modulus;
    	this.argument = this.fixArgument(argument);
    }

    public ComplexNumber add(ComplexNumber z) {
    	RectangularComplex thisRectangular = this.toRectangular();
          
        return thisRectangular.add(z);
    }

    public ComplexNumber subtract(ComplexNumber z) {
    	RectangularComplex thisRectangular = this.toRectangular();
          
        return thisRectangular.subtract(z);
    }

    public ComplexNumber multiply(ComplexNumber z) {
    	PolarComplex other = z.toPolar();
    	
    	double newModulus = this.modulus * other.modulus;
    	double newArgument = this.argument + other.argument;
    	
        return new PolarComplex(newModulus, newArgument);
    }

    public ComplexNumber divideBy(ComplexNumber z) {
    	PolarComplex other = z.toPolar();
    	double newModulus = this.modulus / other.getModulus();
    	double newArgument = this.argument - other.getArgument();
    	newArgument = this.fixArgument(newArgument);
    	
        return new PolarComplex(newModulus, newArgument);
    }

    public ComplexNumber conjugate() {
        return this.toRectangular().conjugate();
    }

    RectangularComplex toRectangular() {
        double realPart = this.calculateRealPart();
        double imaginaryPart = this.calculateImaginaryPart();
    	
        return new RectangularComplex(realPart, imaginaryPart);
    }

    PolarComplex toPolar() {
        return this;
    }
    
    private double calculateRealPart() {
    	double realPart = Math.cos(this.argument) * this.modulus;
    	
    	return realPart;
    }
    
    private double calculateImaginaryPart() {
    	double imaginaryPart = Math.sin(this.argument) * this.modulus;
    	
    	return imaginaryPart;
    }
    
    /*
     * Corrige la entrada de un angulo negativo
     */
    private double fixArgument(double argument) {
    	if(argument<0) {
    		argument = Math.PI * 2 + argument;
    	}
    	return argument;
    }

    public double getModulus() {
    	return this.modulus;
    }

    public double getArgument() {
    	return this.argument;
    }

    @Override
    public String toString() {
        return "[" + this.modulus + ", " + this.argument + "]";
    }
}
