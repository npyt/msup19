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
    
    @Test
    public void testMultiplyModulus() {
    	double argument = (2.0 / 3) * Math.PI;
    	double modulus = 2;
    	
    	double otherArgument = Math.PI;
    	double otherModulus = 5;

    	ComplexNumber expectedComplex = new PolarComplex(10,(5.0 / 3) * Math.PI);
    	
    	PolarComplex polarComplex = new PolarComplex(modulus, argument);
    	PolarComplex otherPolarComplex = new PolarComplex(otherModulus, otherArgument);
    	
    	ComplexNumber newComplex = polarComplex.multiply(otherPolarComplex);
        
        assertEquals(newComplex.toPolar().getModulus(), expectedComplex.toPolar().getModulus());
    }
    
    @Test
    public void testMultiplyArgument() {
    	double argument = (2.0 / 3) * Math.PI;
    	double modulus = 2;
    	
    	double otherArgument = Math.PI;
    	double otherModulus = 5;

    	ComplexNumber expectedComplex = new PolarComplex(10,(5.0 / 3) * Math.PI);
    	
    	PolarComplex polarComplex = new PolarComplex(modulus, argument);
    	PolarComplex otherPolarComplex = new PolarComplex(otherModulus, otherArgument);
    	
    	ComplexNumber newComplex = polarComplex.multiply(otherPolarComplex);
        
    	assertEquals(newComplex.toPolar().getArgument(), expectedComplex.toPolar().getArgument(), ComplexNumberTest.DELTA);
    }
    
    @Test
    public void testDivideModulus() {
    	double argument = (2.0 / 3) * Math.PI;
    	double modulus = 2;
    	
    	double otherArgument = Math.PI;
    	double otherModulus = 5;

    	ComplexNumber expectedComplex = new PolarComplex(0.4,(5.0 / 3) * Math.PI);
    	
    	PolarComplex polarComplex = new PolarComplex(modulus, argument);
    	PolarComplex otherPolarComplex = new PolarComplex(otherModulus, otherArgument);
    	
    	ComplexNumber newComplex = polarComplex.divideBy(otherPolarComplex);
        
        assertEquals(newComplex.toPolar().getModulus(), expectedComplex.toPolar().getModulus());
    }
    
    @Test
    public void testDivideArgument() {
    	double argument = (2.0 / 3) * Math.PI;
    	double modulus = 2;
    	
    	double otherArgument = Math.PI;
    	double otherModulus = 5;

    	ComplexNumber expectedComplex = new PolarComplex(0.4,(5.0 / 3) * Math.PI);
    	
    	PolarComplex polarComplex = new PolarComplex(modulus, argument);
    	PolarComplex otherPolarComplex = new PolarComplex(otherModulus, otherArgument);
    	
    	ComplexNumber newComplex = polarComplex.divideBy(otherPolarComplex);
        
    	assertEquals(newComplex.toPolar().getArgument(), expectedComplex.toPolar().getArgument(), ComplexNumberTest.DELTA);
    }
    
    @Test  
    public void testAddPolarArgument() {
        PolarComplex somePolar = new PolarComplex(8, (3.0 / 2 ) * Math.PI);
        PolarComplex otherPolar = new PolarComplex(3, Math.PI);

        ComplexNumber addition = somePolar.add(otherPolar);
        
        double expectedArgument = Math.atan(8.0/3) + Math.PI;
        
        assertEquals(addition.toPolar().getArgument(), expectedArgument);
    }
    
    public void testAddPolarModulus() {
        PolarComplex somePolar = new PolarComplex(8, (3.0 / 2 ) * Math.PI);
        PolarComplex otherPolar = new PolarComplex(3, Math.PI);

        ComplexNumber addition = somePolar.add(otherPolar);
        
        double expectedModulus = Math.pow(73, 0.5);
        
        assertEquals(addition.toPolar().getModulus(), expectedModulus);
    }

    @Test
    public void testSubtractPolarArgument() {
    	PolarComplex somePolar = new PolarComplex(8, (3.0 / 2 ) * Math.PI);
        PolarComplex otherPolar = new PolarComplex(3, Math.PI);

        ComplexNumber subtraction = somePolar.subtract(otherPolar);
        
        double expectedArgument = 2 * Math.PI + Math.atan(-8.0/3) ;
        
        assertEquals(subtraction.toPolar().getArgument(), expectedArgument);
    }
    
    @Test
    public void testSubtractPolarModulus() {
    	PolarComplex somePolar = new PolarComplex(8, (3.0 / 2 ) * Math.PI);
        PolarComplex otherPolar = new PolarComplex(3, Math.PI);

        ComplexNumber subtraction = somePolar.subtract(otherPolar);
        
        double expectedModulus = Math.pow(73, 0.5);
        
        assertEquals(subtraction.toPolar().getModulus(), expectedModulus);
    }
    
    @Test
    public void testConjugateArgument() {
        PolarComplex polar = new PolarComplex(4, (4.0 / 3 ) * Math.PI);
        
        ComplexNumber conjugate = polar.conjugate();
        
        double expectedArgument = (-1.0 / 3) * Math.PI + Math.PI ;
        
        assertEquals(conjugate.toPolar().getArgument(), expectedArgument);
    }
    
    @Test
    public void testConjugateModulu() {
    	PolarComplex polar = new PolarComplex(4, (4.0 / 3 ) * Math.PI);

    	ComplexNumber conjugate = polar.conjugate();
        
        double expectedModulus = 4;
        
        assertEquals(conjugate.toPolar().getModulus(), expectedModulus);
    }
}

