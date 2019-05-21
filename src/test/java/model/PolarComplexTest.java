package model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PolarComplexTest {

    @Test
    public void testRealPartToRectangular() {
        double argument = (2.0 / 3) * Math.PI;
        double modulus = 2;

        double expectedRealPart = -1;

        PolarComplex polarComplex = new PolarComplex(modulus, argument);

        RectangularComplex rectangularComplex = polarComplex.toRectangular();

        Assert.assertEquals(rectangularComplex.getRealPart(), expectedRealPart, ComplexNumberTest.DELTA);
    }

    @Test
    public void testImaginaryPartToRectangular() {
        double argument = (2.0 / 3) * Math.PI;
        double modulus = 2;

        double expectedImaginaryPart = Math.sqrt(3);

        PolarComplex polarComplex = new PolarComplex(modulus, argument);

        RectangularComplex rectangularComplex = polarComplex.toRectangular();

        Assert.assertEquals(rectangularComplex.getImaginaryPart(), expectedImaginaryPart, ComplexNumberTest.DELTA);
    }

    @Test
    public void testMultiplyModulus() {
        double argument = (2.0 / 3) * Math.PI;
        double modulus = 2;

        double otherArgument = Math.PI;
        double otherModulus = 5;

        ComplexNumber expectedComplex = new PolarComplex(10, (5.0 / 3) * Math.PI);

        PolarComplex polarComplex = new PolarComplex(modulus, argument);
        PolarComplex otherPolarComplex = new PolarComplex(otherModulus, otherArgument);

        ComplexNumber newComplex = polarComplex.multiply(otherPolarComplex);

        Assert.assertEquals(newComplex.toPolar().getModulus(), expectedComplex.toPolar().getModulus(), ComplexNumberTest.DELTA);
    }

    @Test
    public void testMultiplyArgument() {
        double argument = (2.0 / 3) * Math.PI;
        double modulus = 2;

        double otherArgument = Math.PI;
        double otherModulus = 5;

        ComplexNumber expectedComplex = new PolarComplex(10, (5.0 / 3) * Math.PI);

        PolarComplex polarComplex = new PolarComplex(modulus, argument);
        PolarComplex otherPolarComplex = new PolarComplex(otherModulus, otherArgument);

        ComplexNumber newComplex = polarComplex.multiply(otherPolarComplex);

        double expected = newComplex.toPolar().getArgument();
        double actual = expectedComplex.toPolar().getArgument();
        Assert.assertEquals(expected, actual, ComplexNumberTest.DELTA);
    }

    @Test
    public void testDivideModulus() {
        double argument = (2.0 / 3) * Math.PI;
        double modulus = 2;

        double otherArgument = Math.PI;
        double otherModulus = 5;

        ComplexNumber expectedComplex = new PolarComplex(0.4, (5.0 / 3) * Math.PI);

        PolarComplex polarComplex = new PolarComplex(modulus, argument);
        PolarComplex otherPolarComplex = new PolarComplex(otherModulus, otherArgument);

        ComplexNumber newComplex = polarComplex.divideBy(otherPolarComplex);

        double actual = newComplex.toPolar().getModulus();
        double expected = expectedComplex.toPolar().getModulus();
        Assert.assertEquals(expected, actual, ComplexNumberTest.DELTA);
    }

    @Test
    public void testDivideArgument() {
        double argument = (2.0 / 3) * Math.PI;
        double modulus = 2;

        double otherArgument = Math.PI;
        double otherModulus = 5;

        ComplexNumber expectedComplex = new PolarComplex(0.4, (5.0 / 3) * Math.PI);

        PolarComplex polarComplex = new PolarComplex(modulus, argument);
        PolarComplex otherPolarComplex = new PolarComplex(otherModulus, otherArgument);

        ComplexNumber newComplex = polarComplex.divideBy(otherPolarComplex);
        double actual = newComplex.toPolar().getArgument();
        double expected = expectedComplex.toPolar().getArgument();
        Assert.assertEquals(expected, actual, ComplexNumberTest.DELTA);
    }

    @Test
    public void testAddPolarArgument() {
        PolarComplex somePolar = new PolarComplex(8, (3.0 / 2) * Math.PI);
        PolarComplex otherPolar = new PolarComplex(3, Math.PI);

        ComplexNumber addition = somePolar.add(otherPolar);

        double expectedArgument = Math.atan(8.0 / 3) + Math.PI;

        double actualArgument = addition.toPolar().getArgument();
        Assert.assertEquals(expectedArgument, actualArgument, ComplexNumberTest.DELTA);
    }

    @Test
    public void testAddPolarModulus() {
        PolarComplex somePolar = new PolarComplex(8, (3.0 / 2) * Math.PI);
        PolarComplex otherPolar = new PolarComplex(3, Math.PI);

        ComplexNumber addition = somePolar.add(otherPolar);

        double expectedModulus = Math.pow(73, 0.5);
        double actual = addition.toPolar().getModulus();

        System.out.println(Math.abs(expectedModulus - actual));
        Assert.assertEquals(expectedModulus, actual, ComplexNumberTest.DELTA);
    }

    @Test
    public void testSubtractPolarArgument() {
        PolarComplex somePolar = new PolarComplex(8, (3.0 / 2) * Math.PI);
        PolarComplex otherPolar = new PolarComplex(3, Math.PI);

        ComplexNumber subtraction = somePolar.subtract(otherPolar);

        double expectedArgument = 2 * Math.PI + Math.atan(-8.0 / 3);

        double actualArgument = subtraction.toPolar().getArgument();
        Assert.assertEquals(expectedArgument, actualArgument, ComplexNumberTest.DELTA);
    }

    @Test
    public void testSubtractPolarModulus() {
        PolarComplex somePolar = new PolarComplex(8, (3.0 / 2) * Math.PI);
        PolarComplex otherPolar = new PolarComplex(3, Math.PI);

        ComplexNumber subtraction = somePolar.subtract(otherPolar);

        double expectedModulus = Math.pow(73, 0.5);

        double actualModulus = subtraction.toPolar().getModulus();
        Assert.assertEquals(expectedModulus, actualModulus, ComplexNumberTest.DELTA);
    }

    @Test
    public void testConjugateArgument() {
        PolarComplex polar = new PolarComplex(4, (4.0 / 3) * Math.PI);

        ComplexNumber conjugate = polar.conjugate();

        double expectedArgument = (-1.0 / 3) * Math.PI + Math.PI;

        double actualArgument = conjugate.toPolar().getArgument();
        Assert.assertEquals(expectedArgument, actualArgument, ComplexNumberTest.DELTA);
    }

    @Test
    public void testConjugateModulus() {
        PolarComplex polar = new PolarComplex(4, (4.0 / 3) * Math.PI);

        ComplexNumber conjugate = polar.conjugate();

        double expectedModulus = 4;

        double actualModulus = conjugate.toPolar().getModulus();
        Assert.assertEquals(expectedModulus, actualModulus, ComplexNumberTest.DELTA);
    }

    @Test
    public void fixArgumentLessThan0() {
        PolarComplex needsFix = new PolarComplex(2, -Math.PI);
        PolarComplex expected = new PolarComplex(2, Math.PI);

        double needsFixArgument = needsFix.getArgument();
        double expectedArgument = expected.getArgument();
        Assert.assertEquals(expectedArgument, needsFixArgument, ComplexNumberTest.DELTA);
    }

    @Test
    public void fixArgumentMuchLessThan0() {
        PolarComplex needsFix = new PolarComplex(2, -5 * Math.PI);
        PolarComplex expected = new PolarComplex(2, Math.PI);

        double needsFixArgument = needsFix.getArgument();
        double expectedArgument = expected.getArgument();
        Assert.assertEquals(expectedArgument, needsFixArgument, ComplexNumberTest.DELTA);
    }

    @Test
    public void fixArgumentGreaterThan2Pi() {
        PolarComplex needsFix = new PolarComplex(3, 5 * Math.PI);
        PolarComplex expected = new PolarComplex(3, Math.PI);

        double needsFixArgument = needsFix.getArgument();
        double expectedArgument = expected.getArgument();
        Assert.assertEquals(expectedArgument, needsFixArgument, ComplexNumberTest.DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testPowerInvalidExponent() {
        new PolarComplex(1, Math.PI).power(-1);
    }

    @Test
    public void testPowerArgument() {
        PolarComplex base = new PolarComplex(4, Math.PI / 2);
        int exponent = 4;

        ComplexNumber result = base.power(exponent);
        PolarComplex polarResult = result.toPolar();
        Assert.assertEquals(2 * Math.PI, polarResult.getArgument(), ComplexNumberTest.DELTA);
    }

    @Test
    public void testPowerModulus() {
        PolarComplex base = new PolarComplex(4, Math.PI / 2);
        int exponent = 4;

        ComplexNumber result = base.power(exponent);
        PolarComplex polarResult = result.toPolar();
        Assert.assertEquals(256, polarResult.getModulus(), ComplexNumberTest.DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testRootInvalidIndex() {
        new PolarComplex(1, Math.PI).roots(-1);
    }

    @Test
    public void testRootResultsCount() {
        PolarComplex radicand = new PolarComplex(8, 3 * Math.PI / 2);
        int index = 3;

        List<ComplexNumber> results = radicand.roots(index);
        int size = results.size();
        Assert.assertEquals(3, size);
    }

    @Test
    public void testRootArgument() {
        PolarComplex radicand = new PolarComplex(8, 3 * Math.PI / 2);
        int index = 3;

        List<ComplexNumber> results = radicand.roots(index);
        PolarComplex firstResult = results.get(0).toPolar();

        double expected = Math.PI / 2;

        Assert.assertEquals(expected, firstResult.getArgument(), ComplexNumberTest.DELTA);
    }

    @Test
    public void testRootModulus() {
        PolarComplex radicand = new PolarComplex(8, 3 * Math.PI / 2);
        int index = 3;

        List<ComplexNumber> results = radicand.roots(index);
        PolarComplex firstResult = results.get(1).toPolar();

        double expected = Math.pow(8, 1D / 3D);

        Assert.assertEquals(expected, firstResult.getModulus(), ComplexNumberTest.DELTA);
    }
}

