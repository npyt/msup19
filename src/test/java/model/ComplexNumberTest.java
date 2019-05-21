package model;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ComplexNumberTest {

    protected static double DELTA = 1e-10;

    @Test
    public void testIsNullComplex() {
        ComplexNumber z1 = new RectangularComplex(0, 0);
        assertTrue(z1.isNullComplex());

        ComplexNumber z2 = new RectangularComplex(4, 0);
        assertFalse(z2.isNullComplex());

        ComplexNumber z3 = new RectangularComplex(0, -2);
        assertFalse(z3.isNullComplex());

        ComplexNumber z4 = new PolarComplex(0, Math.PI);
        assertTrue(z4.isNullComplex());

        ComplexNumber z5 = new PolarComplex(2, 0);
        assertFalse(z5.isNullComplex());
    }

}
