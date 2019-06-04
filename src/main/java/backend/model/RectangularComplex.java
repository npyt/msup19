package backend.model;

import java.text.DecimalFormat;

/**
 * Representa la forma binomial de un complejo
 */
public class RectangularComplex extends ComplexNumber {

    private final double realPart;
    private final double imaginaryPart;

    public RectangularComplex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public PolarComplex toPolar() {
        double modulus = this.calculateModulus();
        double argument = this.calculateArgument();

        return new PolarComplex(modulus, argument);
    }

    public RectangularComplex toRectangular() {
        return this;
    }

    public double getImaginaryPart() {
        return this.imaginaryPart;
    }

    public double getRealPart() {
        return this.realPart;
    }

    private double calculateModulus() {
        if (this.isNullComplex()) {
            return 0.0;
        }

        double modulusSquared = this.realPart * this.realPart + this.imaginaryPart * this.imaginaryPart;
        return Math.sqrt(modulusSquared);
    }

    private double calculateArgument() {
        if (this.realPart == 0) {
            if (this.imaginaryPart > 0) {
                return Math.PI / 2.0;
            }
            if (this.imaginaryPart < 0) {
                return Math.PI / -2.0;
            }

            return 0;
        }

        double arctan = Math.atan(this.imaginaryPart / this.realPart);

        // Corrijo cuadrante equivalente y giro en el 4to cuadrante

        if ((this.realPart < 0 && this.imaginaryPart > 0 && arctan < 0)
                || this.realPart < 0 && this.imaginaryPart < 0 && arctan > 0) {
            arctan += Math.PI;
        } else if (this.realPart > 0 && this.imaginaryPart < 0 && arctan < 0) {
            arctan = (2.0 * Math.PI) + arctan;
        }

        return arctan;
    }

    @Override
    public boolean isNullComplex() {
        return this.realPart == 0 && this.imaginaryPart == 0;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = this.getDecimalFormat();

        String realPartString = decimalFormat.format(this.realPart);
        String imaginaryPartString = decimalFormat.format(this.imaginaryPart);

        return "(" + realPartString + "; " + imaginaryPartString + ")";
    }
}
