package model;

import java.util.ArrayList;
import java.util.List;

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
     *
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
     *
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
     * Potencia
     *
     * @param n exponente natural ó 0.
     * @throws ArithmeticException si el exponente es inválido.
     */
    ComplexNumber power(int n) {
        if (n < 0) {
            throw new ArithmeticException("El exponente debe ser natural ó 0, pero se ingresó " + n);
        }

        PolarComplex polar = this.toPolar();
        double polarModulus = polar.getModulus();
        double polarArgument = polar.getArgument();

        double resultModulus = Math.pow(polarModulus, n);
        double resultArgument = polarArgument * n;

        return new PolarComplex(resultModulus, resultArgument);
    }

    /**
     * Radicación. Devuelve una lista ordenada de los resultados, de menor a mayor argumento.
     *
     * @param n índice natural.
     * @throws ArithmeticException si el índice es inválido.
     */
    List<ComplexNumber> root(int n) {
        if (n <= 0) {
            throw new ArithmeticException("El índice debe ser natural, pero se ingresó " + n);
        }

        PolarComplex polar = this.toPolar();
        double polarModulus = polar.getModulus();
        double polarArgument = polar.getArgument();

        double resultModulus = Math.pow(polarModulus, 1D / n);
        List<ComplexNumber> results = new ArrayList<ComplexNumber>();
        for (int k = 0; k < n; k++) {
            double resultArgument = (polarArgument + 2 * k * Math.PI) / n;
            ComplexNumber result = new PolarComplex(resultModulus, resultArgument);
            results.add(result);
        }

        return results;
    }

    /**
     * Devuelve el conjugado de esta instancia
     */
    ComplexNumber conjugate() {
        RectangularComplex thisRectangular = this.toRectangular();
        return new RectangularComplex(thisRectangular.getRealPart(), -thisRectangular.getImaginaryPart());
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
    public boolean equals(Object o) {
        if (!(o instanceof ComplexNumber)) {
            return false;
        }

        RectangularComplex z1 = this.toRectangular();
        RectangularComplex z2 = ((ComplexNumber) o).toRectangular();

        return z1.getRealPart() == z2.getRealPart() && z1.getImaginaryPart() == z2.getImaginaryPart();
    }
}
