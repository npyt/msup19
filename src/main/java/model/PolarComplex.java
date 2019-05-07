package model;

/**
 * Representa la forma polar de un complejo
 */
public class PolarComplex extends ComplexNumber {

    private final double modulus;
    private final double argument;

    public PolarComplex(double modulus, double argument) {
    	this.modulus = modulus;
    	this.argument = fixArgument(argument);
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
     * Corrige la entrada de un argumento fuera del primer giro positivo.
     */
    public static double fixArgument(double argument) {
    	if(argument < 0) {
    		return fixArgument(Math.PI * 2 + argument);
    	}

    	if(argument > Math.PI * 2) {
    	    argument = argument % (Math.PI * 2);
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
