package model;

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

    @Test
    public void toPolar1stQuadrantArgument() {
        RectangularComplex rectangularComplex = new RectangularComplex(3, 3);
        PolarComplex polar = rectangularComplex.toPolar();

        PolarComplex expectedPolar = new PolarComplex(3 * Math.sqrt(2), (1.0 / 4) * Math.PI);
        assertEquals(expectedPolar.getArgument(), polar.getArgument());
    }

    @Test
    public void toPolar2ndQuadrantArgument() {
        RectangularComplex rectangularComplex = new RectangularComplex(-3, 3);
        PolarComplex polar = rectangularComplex.toPolar();

        PolarComplex expectedPolar = new PolarComplex(3 * Math.sqrt(2), (3.0 / 4) * Math.PI);
        assertEquals(expectedPolar.getArgument(), polar.getArgument());
    }

    @Test
    public void toPolar3thQuadrantArgument() {
        RectangularComplex rectangularComplex = new RectangularComplex(-3, -3);
        PolarComplex polar = rectangularComplex.toPolar();

        PolarComplex expectedPolar = new PolarComplex(3 * Math.sqrt(2), (5.0 / 4) * Math.PI);
        assertEquals(expectedPolar.getArgument(), polar.getArgument());
    }

    @Test
    public void toPolar4thQuadrantArgument() {
        RectangularComplex rectangularComplex = new RectangularComplex(3, -3);
        PolarComplex polar = rectangularComplex.toPolar();

        PolarComplex expectedPolar = new PolarComplex(3 * Math.sqrt(2), (7.0 / 4) * Math.PI);
        assertEquals(expectedPolar.getArgument(), polar.getArgument());
    }

    @Test
    public void testConjugate() {
        RectangularComplex rectangularComplex = new RectangularComplex(4, -1);
        RectangularComplex conjugate = (RectangularComplex) rectangularComplex.conjugate();

        assertEquals(new RectangularComplex(4, 1), conjugate);
    }

}
