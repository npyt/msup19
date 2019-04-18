package model;

/**
 * Representa la forma binomial de un complejo
 */
public class RectangularComplex extends ComplexNumber {

    private double realPart;
    private double imaginaryPart;

    public RectangularComplex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber add(ComplexNumber z) {
        RectangularComplex rectangularZ = z.toRectangular();

        double realPartAddition = this.realPart + rectangularZ.getRealPart();
        double imaginaryPartAddition = this.imaginaryPart + rectangularZ.getImaginaryPart();

        return new RectangularComplex(realPartAddition, imaginaryPartAddition);
    }

    public ComplexNumber subtract(ComplexNumber z) {
        RectangularComplex rectangularZ = z.toRectangular();

        double realPartSubtraction = this.realPart - rectangularZ.getRealPart();
        double imaginaryPartSubtraction = this.imaginaryPart - rectangularZ.getImaginaryPart();

        return new RectangularComplex(realPartSubtraction, imaginaryPartSubtraction);
    }

    public ComplexNumber multiply(ComplexNumber z) {
        PolarComplex polarComplex = this.toPolar();

        return polarComplex.multiply(z);
    }

    public ComplexNumber divideBy(ComplexNumber z) {
        PolarComplex polarComplex = this.toPolar();

        return polarComplex.divideBy(z);
    }

    public PolarComplex toPolar() {
        double modulus = this.calculateModulus();
        double argument = this.calculateArgument();

        return new PolarComplex(modulus, argument);
    }

    public RectangularComplex toRectangular() {
        return this;
    }

    public RectangularComplex conjugate() {
        return new RectangularComplex(this.realPart, - this.imaginaryPart);
    }

    public double getImaginaryPart() {
        return this.imaginaryPart;
    }

    public double getRealPart() {
        return this.realPart;
    }

    private double calculateModulus() {
        if(this.isNullComplex()) {
            return 0.0;
        }
        
        double modulusSquared = this.realPart * this.realPart + this.imaginaryPart * this.imaginaryPart;
        return Math.sqrt(modulusSquared);
    }

    private double calculateArgument() {
        if(this.realPart == 0) {
            if(this.imaginaryPart > 0) {
                return Math.PI / 2.0;
            }
            if(this.imaginaryPart < 0) {
                return Math.PI / -2.0;
            }       
            
            return 0;
        }

        double arctan = Math.atan(this.imaginaryPart / this.realPart);
        
        // Corrijo cuadrante equivalente y giro en el 4to cuadrante
        
        if((this.realPart < 0 && this.imaginaryPart > 0 && arctan < 0)  
        	|| this.realPart < 0 && this.imaginaryPart < 0 && arctan > 0){
            arctan += Math.PI;
        }else if (this.realPart > 0 && this.imaginaryPart < 0 && arctan < 0) {
        	arctan = (2.0 * Math.PI) + arctan;
        }
        
        return arctan;
    }

    public boolean isNullComplex() {
    	if (this.realPart == 0 && this.imaginaryPart == 0) {
    		return true;
    	}else {
    		return false;
    	}
    }

    @Override
    public String toString() {
        return "(" + this.realPart + ", " + this.imaginaryPart + ")";
    }
}
