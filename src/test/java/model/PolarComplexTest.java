package model;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

public class PolarComplexTest {

    @Test
    public void testRealPartToRectangular() {
    	double argument = (2.0 / 3) * Math.PI;
    	double modulus = 2;
    	
    	double expectedRealPart = -1;
    	
    	PolarComplex polarComplex = new PolarComplex(modulus, argument);
    	
        RectangularComplex rectangularComplex = polarComplex.toRectangular();
        
        assertEquals(rectangularComplex.getRealPart(), expectedRealPart, ComplexNumberTest.DELTA);
    }
    
    @Test
    public void testImaginaryPartToRectangular() {
    	double argument = (2.0 / 3) * Math.PI;
    	double modulus = 2;

    	double expectedImaginaryPart = Math.sqrt(3);
    	
    	PolarComplex polarComplex = new PolarComplex(modulus, argument);
    	
        RectangularComplex rectangularComplex = polarComplex.toRectangular();
        
        assertEquals(rectangularComplex.getImaginaryPart(), expectedImaginaryPart, ComplexNumberTest.DELTA);
    }
}

