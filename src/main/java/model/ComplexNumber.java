package model;

public abstract class ComplexNumber {

    /**
     * Suma de complejos
     */
    abstract ComplexNumber add(ComplexNumber z);

    /**
     * Resta de complejos.
     * @param z sustraendo
     */
    abstract ComplexNumber subtract(ComplexNumber z);

    /**
     * Multiplicacion de complejos
     */
    abstract ComplexNumber multiply(ComplexNumber z);

    /**
     * Cociente de complejos
     * @param z divisor
     */
    abstract ComplexNumber divideBy(ComplexNumber z);

    /**
     * Devuelve el conjugado de esta instancia
     */
    abstract ComplexNumber conjugate();

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
    abstract boolean isNullComplex();

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
