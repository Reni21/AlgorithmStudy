package array;

import org.junit.Assert;
import org.junit.Test;

public class Arr1Test {
    private final Arr1 instance = new Arr1();

    @Test
    public void shouldReturnMinusOneIfArrayWithoutRepeats() {
        int[] test = {33, 3, 4, 5};
        int res = instance.firstDuplicate(test);
        Assert.assertEquals(-1, res);
    }

    @Test
    public void shouldReturnMinusOneIfArrayLengthEqualsOne() {
        int[] test = {33};
        int res = instance.firstDuplicate(test);
        Assert.assertEquals(-1, res);
    }

    @Test
    public void shouldReturnMinusOneIfArrayIsEmpty() {
        int[] test = {};
        int res = instance.firstDuplicate(test);
        Assert.assertEquals(-1, res);
    }

    @Test
    public void shouldReturnFirstRepeatedValue() {
        int[] test = {33, 3, 4, 3, 5, 4, 7};
        int res = instance.firstDuplicate(test);
        Assert.assertEquals(3, res);
    }
}