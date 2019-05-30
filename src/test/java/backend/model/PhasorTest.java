package backend.model;

import org.junit.Assert;
import org.junit.Test;

import backend.model.Phasor.TrigFun;

public class PhasorTest {
	double fasev1 = (-1)*Math.PI/3;
	double fasev2 = (5)*Math.PI/12;
	
	double DELTA = 0.01;

	@Test
    public void testSumaDeFasores() throws Exception {
		
		Phasor v1 = new Phasor(10,TrigFun.COS,3,fasev1);
		Phasor v2 = new Phasor(5,TrigFun.COS,3,fasev2);

        Phasor expected = new Phasor(7.36,TrigFun.COS,3,5.74);

        Phasor resultado = v1.add(v2);

        Assert.assertEquals(expected.getAmplitud(),resultado.getAmplitud(), this.DELTA);
        Assert.assertEquals(expected.getFase(), resultado.getFase(), this.DELTA);
        Assert.assertEquals(expected.getFrecuencia(), resultado.getFrecuencia(), this.DELTA);
        
    }
	
	@Test(expected = Exception.class)
    public void testSumaDeFasoresDistintaFrecuencia() throws Exception {
		
		Phasor v1 = new Phasor(10,TrigFun.COS,3,fasev1);
		Phasor v2 = new Phasor(5,TrigFun.COS,4,fasev2);

        v1.add(v2);
    
    }
	
	@Test
    public void testSINtoCOS() throws Exception {
		
		Phasor v2 = new Phasor(5,TrigFun.SIN,4,fasev2);
		
		v2.toCOS();
        
        Assert.assertEquals(5,v2.getAmplitud(), this.DELTA);
        Assert.assertEquals(Math.PI/12.00, v2.getFase(), this.DELTA);
        Assert.assertEquals(TrigFun.COS, v2.getFuncion());
    
    }
	
	@Test
    public void testSumaDeFasoresDistintaFuncion() throws Exception {
		
		Phasor v1 = new Phasor(10,TrigFun.COS,4,fasev1);
		Phasor v2 = new Phasor(5,TrigFun.SIN,4,fasev2);
		
		Phasor resultado = v1.add(v2);
        
        Assert.assertEquals(12.28,resultado.getAmplitud(), this.DELTA);
        Assert.assertEquals(5.64, resultado.getFase(), this.DELTA);
    
    }
	
    @Test
    public void testPhasorToRectangular() {
    	
    	Phasor v1 = new Phasor(10,TrigFun.COS,3,fasev1);
        
    	RectangularComplex expected = new RectangularComplex(5, -8.66);
    	RectangularComplex resultado = v1.toRectangular();
    	
    	Assert.assertEquals(expected.getImaginaryPart(),resultado.getImaginaryPart() , this.DELTA);
    	Assert.assertEquals(expected.getRealPart(),resultado.getRealPart() , this.DELTA);
    
    }
    
    @Test
    public void testPhasorToPolar() {
    	
    	Phasor v1 = new Phasor(10,TrigFun.COS,3,fasev1);
        
    	PolarComplex expected = new PolarComplex(10,fasev1);
    	PolarComplex resultado = v1.toPolar();
    	
    	Assert.assertEquals(expected.getArgument(),resultado.getArgument() , this.DELTA);
        Assert.assertEquals(expected.getModulus(),resultado.getModulus() , this.DELTA);
    
    }
    
    @Test
    public void testFasorSumaDeBinomios() {
    	
    	Phasor v1 = new Phasor(10,TrigFun.COS,3,fasev1);
    	Phasor v2 = new Phasor(5,TrigFun.COS,3,fasev2);
        
    	ComplexNumber sumaDeBinomicos = 
    			v1.toRectangular()
    			.add(v2.toRectangular());
    	
    	
    	RectangularComplex expected = new RectangularComplex(6.29, -3.83);
    	RectangularComplex resultado = sumaDeBinomicos.toRectangular(); 
    	
    	Assert.assertEquals(expected.getRealPart(),resultado.getRealPart() , this.DELTA);
        Assert.assertEquals(expected.getImaginaryPart(),resultado.getImaginaryPart() , this.DELTA);
    
    }
}