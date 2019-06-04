package backend.model;

import java.text.DecimalFormat;

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

    public RectangularComplex toRectangular() {
        double realPart = this.calculateRealPart();
        double imaginaryPart = this.calculateImaginaryPart();

        return new RectangularComplex(realPart, imaginaryPart);
    }

    public PolarComplex toPolar() {
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
    private double fixArgument(double argument) {
        if (argument < 0) {
            return fixArgument(Math.PI * 2 + argument);
        }

        if (argument > Math.PI * 2) {
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
        DecimalFormat decimalFormat = this.getDecimalFormat();

        String modulusString = decimalFormat.format(this.modulus);
        String argumentString = decimalFormat.format(this.argument);

        return "[" + modulusString + "; " + argumentString + "]";
    }
}
