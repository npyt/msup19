package backend.util;

import org.junit.Assert;
import org.junit.Test;

public class ParseUtilsTest {

    @Test
    public void testIsNumeric() {
        String piString = Double.toString(3.1415);
        Assert.assertTrue(ParseUtils.isNumeric(piString));
    }

    @Test
    public void testIsNumericShouldFail() {
        Assert.assertFalse(ParseUtils.isNumeric("1.12a3"));
    }

    @Test
    public void isEmptyStringNumeric() {
        Assert.assertFalse(ParseUtils.isNumeric(""));
    }
}
