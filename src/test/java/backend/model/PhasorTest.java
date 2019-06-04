package backend.model;

import org.junit.Assert;
import org.junit.Test;

import backend.model.Phasor.TrigFun;

public class PhasorTest {


	@Test
    public void testSumaDeFasores() {

		Phasor v1 = new Phasor(10,TrigFun.COS,3,(-1D/3D)*Math.PI);
		Phasor v2 = new Phasor(5,TrigFun.COS,3,(5D/12D)*Math.PI);

        Phasor expected = new Phasor(7.36,TrigFun.COS,3,-0.55);

        Phasor resultado = v1.add(v2);

        Assert.assertEquals(expected.getAmplitud(),resultado.getAmplitud(), 1e-2);
        Assert.assertEquals(expected.getFase(), resultado.getFase(), ComplexNumberTest.DELTA);
        Assert.assertEquals(expected.getFrecuencia(), resultado.getFrecuencia(), ComplexNumberTest.DELTA);
        
    }
	
    @Test
    public void testPhasorToRectangular() {
    	
    	Phasor v1 = new Phasor(10,TrigFun.COS,3,(-1/3)*Math.PI);
        
    	RectangularComplex expected = new RectangularComplex(5, -8.66);
    	RectangularComplex resultado = v1.toRectangular();
    	
    	Assert.assertEquals(expected.getRealPart(),resultado.getRealPart() , ComplexNumberTest.DELTA);
        Assert.assertEquals(expected.getImaginaryPart(),resultado.getImaginaryPart() , ComplexNumberTest.DELTA);
    
    }
    
    @Test
    public void testPhasorToPolar() {
    	
    	Phasor v1 = new Phasor(10,TrigFun.COS,3,(-1/3)*Math.PI);
        
    	PolarComplex expected = new PolarComplex(10,(-1/3)*Math.PI);
    	PolarComplex resultado = v1.toPolar();
    	
    	Assert.assertEquals(expected.getArgument(),resultado.getArgument() , ComplexNumberTest.DELTA);
        Assert.assertEquals(expected.getModulus(),resultado.getModulus() , ComplexNumberTest.DELTA);
    
    }
}