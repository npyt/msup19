package model;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RectangularComplexTest {

    @Test
    public void testConstructor() {
        RectangularComplex z = new RectangularComplex(90, 0);

        assertEquals(90.0, z.getRealPart());
        assertEquals(0.0, z.getImaginaryPart());
    }

    @Test
    public void testAddRectangular() {
        RectangularComplex someRectangular = new RectangularComplex(4, 5);
        RectangularComplex otherRectangular = new RectangularComplex(2, -1);

        ComplexNumber addition = someRectangular.add(otherRectangular);
        ComplexNumber expected = new RectangularComplex(6, 4);

        assertEquals(expected, addition);
    }

    @Test
    public void testSubtractRectangular() {
        RectangularComplex someRectangular = new RectangularComplex(4, 5);
        RectangularComplex otherRectangular = new RectangularComplex(2, -1);

        ComplexNumber subtraction = someRectangular.subtract(otherRectangular);
        ComplexNumber expected = new RectangularComplex(2, 6);

        assertEquals(expected, subtraction);
    }

    //TODO des-ignorar una vez implementado el polar
    @Ignore
    @Test
    public void toPolar1stQuadrant() {
        RectangularComplex rectangularComplex = new RectangularComplex(3, 3);
        PolarComplex polar = rectangularComplex.toPolar();

        double module = polar.getModule();
        double argument = polar.getArgument();

        assertEquals(3, module);
        assertEquals(Math.PI / 4.0, argument);
    }

    @Ignore
    @Test
    public void toPolar3rdQuadrant() {
        RectangularComplex rectangularComplex = new RectangularComplex(-3, -3);
        PolarComplex polar = rectangularComplex.toPolar();

        double module = polar.getModule();
        double argument = polar.getArgument();

        assertEquals(3, module);
        assertEquals((-3/4) * Math.PI, argument);
    }

    @Test
    public void testConjugate() {
        RectangularComplex rectangularComplex = new RectangularComplex(4, -1);
        RectangularComplex conjugate = rectangularComplex.conjugate();

        assertEquals(new RectangularComplex(4, 1), conjugate);
    }
}
