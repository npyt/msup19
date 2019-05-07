package model;

public abstract class ComplexNumber {

    /**
     * Suma de complejos
     */
    ComplexNumber add(ComplexNumber z) {
    	RectangularComplex rectangularT = this.toRectangular();
        RectangularComplex rectangularZ = z.toRectangular();

        double realPartAddition = rectangularT.getRealPart() + rectangularZ.getRealPart();
        double imaginaryPartAddition = rectangularT.getImaginaryPart() + rectangularZ.getImaginaryPart();

        return new RectangularComplex(realPartAddition, imaginaryPartAddition);
    }

    /**
     * Resta de complejos.
     * @param z sustraendo
     */
    ComplexNumber subtract(ComplexNumber z) {
    	RectangularComplex rectangularT = this.toRectangular();
        RectangularComplex rectangularZ = z.toRectangular();

        double realPartAddition = rectangularT.getRealPart() - rectangularZ.getRealPart();
        double imaginaryPartAddition = rectangularT.getImaginaryPart() - rectangularZ.getImaginaryPart();

        return new RectangularComplex(realPartAddition, imaginaryPartAddition);
    }

    /**
     * Multiplicacion de complejos
     */
    ComplexNumber multiply(ComplexNumber z) {
    	PolarComplex thisp = this.toPolar();
    	PolarComplex other = z.toPolar();
    	
    	double newModulus = thisp.getModulus() * other.getModulus();
    	double newArgument = thisp.getArgument() + other.getArgument();
    	
        return new PolarComplex(newModulus, newArgument);
    }

    /**
     * Cociente de complejos
     * @param z divisor
     */
    ComplexNumber divideBy(ComplexNumber z) {
    	PolarComplex thisp = this.toPolar();
    	PolarComplex other = z.toPolar();
    	
    	double newModulus = thisp.getModulus() / other.getModulus();
    	double newArgument = thisp.getArgument() - other.getArgument();
    	
        return new PolarComplex(newModulus, newArgument);
    }

    /**
     * Devuelve el conjugado de esta instancia
     */
    ComplexNumber conjugate() {
    	RectangularComplex thisRectangular = this.toRectangular();
        return new RectangularComplex(thisRectangular.getRealPart(), - thisRectangular.getImaginaryPart());
    }

    /**
     * Devuelve el equivalente al complejo en forma binomial
     */
    abstract RectangularComplex toRectangular();

    /**
     * Devuelve el equivalente al complejo en forma polar
     */
    abstract PolarComplex toPolar();

    /**
     * Devuelve <code>true</code> si el complejo es el complejo nulo
     */
    public boolean isNullComplex() {
        return this.toRectangular().isNullComplex();
    }

    @Override
    public String toString() {
        RectangularComplex rectangular = this.toRectangular();
        PolarComplex polar = this.toPolar();
        String s = "Forma binomial: " + rectangular.toString() + " - Forma polar: " + polar.toString();

        return s;
    }

    /**
     * Igualdad de complejos (por definicion: igualdad de sus partes reales e imaginarias)
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof ComplexNumber)) {
            return false;
        }

        RectangularComplex z1 = this.toRectangular();
        RectangularComplex z2 = ((ComplexNumber) o).toRectangular();

        return z1.getRealPart() == z2.getRealPart() && z1.getImaginaryPart() == z2.getImaginaryPart();
    }
}
