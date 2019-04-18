package model;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PolarComplexTest {
    
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
    	
    	double quadrant = Math.atan2(expectedImaginaryPart, expectedRealPart);
    	
    	PolarComplex polarComplex = new PolarComplex(modulus, argument);
    	
        RectangularComplex rectangularComplex = polarComplex.toRectangular();
        RectangularComplex expectedRectangular = new RectangularComplex(expectedRealPart, expectedImaginaryPart);
        
        assertEquals(expectedRectangular.getImaginaryPart(), expectedImaginaryPart);
    }
}

