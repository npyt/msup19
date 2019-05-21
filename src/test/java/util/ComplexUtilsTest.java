package util;

import model.ComplexNumber;
import model.ComplexNumberTest;
import model.PolarComplex;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ComplexUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() {
        ComplexUtils.primitiveRoots(-1);
    }

    @Test
    public void testPrimitiveRootsCount() {
        List<ComplexNumber> primitiveRoots = ComplexUtils.primitiveRoots(8);
        int size = primitiveRoots.size();

        Assert.assertEquals(4, size);
    }

    @Test
    public void testPrimitiveRootsArguments() {
        List<ComplexNumber> primitiveRoots = ComplexUtils.primitiveRoots(3);

        PolarComplex w1 = primitiveRoots.get(0).toPolar();
        PolarComplex w2 = primitiveRoots.get(1).toPolar();

        Assert.assertEquals(2D * Math.PI / 3, w1.getArgument(), ComplexNumberTest.DELTA);
        Assert.assertEquals(4D * Math.PI / 3, w2.getArgument(), ComplexNumberTest.DELTA);
    }
}
