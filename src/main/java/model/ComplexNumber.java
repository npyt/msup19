package model;

public abstract class ComplexNumber {
    abstract ComplexNumber add(ComplexNumber z);
    abstract ComplexNumber subtract(ComplexNumber z);
    abstract ComplexNumber multiply(ComplexNumber z);
    abstract ComplexNumber divideBy(ComplexNumber z);
    abstract ComplexNumber conjugate();
    abstract RectangularComplex toRectangular();
    abstract PolarComplex toPolar();

    public boolean isNullComplex(){
        double realPart = this.toRectangular().getRealPart();
        double imaginaryPart = this.toRectangular().getImaginaryPart();

        return realPart == 0 && imaginaryPart == 0;
    }

    @Override
    public String toString() {
        RectangularComplex rectangular = this.toRectangular();
        PolarComplex polar = this.toPolar();
        String s = "Forma binomial: (" + rectangular.getRealPart() + ", " + rectangular.getImaginaryPart() +
                ") - Forma polar: [" + polar.getModule() + ", " + polar.getArgument() + "]";

        return s;
    }

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
