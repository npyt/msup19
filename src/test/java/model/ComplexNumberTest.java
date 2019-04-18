package model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ComplexNumberTest {

	private static double DELTA = 1e-15;
	
	@Before
	public void init() {
		
	}
	
    @Ignore
    @Test
    public void testIsNullComplex() {
        ComplexNumber z1 = new RectangularComplex(0, 0);
        assertTrue(z1.isNullComplex());

        ComplexNumber z2 = new RectangularComplex(4, 0);
        assertFalse(z2.isNullComplex());

        ComplexNumber z3 = new RectangularComplex(0, -2);
        assertFalse(z3.isNullComplex());

        //TODO tests para forma polar
    }

    @Ignore
    @Test
    public void testEquals() {
        ComplexNumber rectangular = new RectangularComplex(1, 1);
        ComplexNumber polar = new PolarComplex(1, Math.PI / 4);

        assertEquals(rectangular, polar);
    }
    
    @Test
    public void testRealParttoRectangular() {
    	double argument = (2.0 / 3) * Math.PI;
    	double modulus = 2;
    	
    	double expectedRealPart = -1;
    	double expectedImaginaryPart = Math.sqrt(3);
    	
    	PolarComplex polarComplex = new PolarComplex(modulus, argument);
    	
        RectangularComplex rectangularComplex = polarComplex.toRectangular();
        RectangularComplex expectedRectangular = new RectangularComplex(expectedRealPart, expectedImaginaryPart);
        
        assertEquals(expectedRectangular.getRealPart(), expectedRealPart);
    }
    
    @Test
    public void testImaginaryParttoRectangular() {
    	double argument = (2.0 / 3) * Math.PI;
    	double modulus = 2;

    	double expectedRealPart = -1;
    	double expectedImaginaryPart = Math.sqrt(3);
    	
    	
    	PolarComplex polarComplex = new PolarComplex(modulus, argument);
    	
        RectangularComplex rectangularComplex = polarComplex.toRectangular();
        RectangularComplex expectedRectangular = new RectangularComplex(expectedRealPart, expectedImaginaryPart);
        
        assertEquals(expectedRectangular.getImaginaryPart(), expectedImaginaryPart);
    }
}
