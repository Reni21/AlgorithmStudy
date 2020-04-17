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

    @Test
    public void shouldReturnFirstAbsentValue(){
        int[] test = {33, 3, 4, 3, 5, 4, 7}; // 6
        int res = instance.gettingTheDifferentNumber(test);
        Assert.assertEquals(6, res);
    }

    @Test
    public void shouldReturnIntegerPlusOneIfArrayLengthIsOne(){
        int[] test = {33}; // 34
        int res = instance.gettingTheDifferentNumber(test);
        Assert.assertEquals(34, res);
    }

    @Test
    public void shouldReturnIntegerPlusOneIfArrayLengthIsOneV3(){
        int[] test = {33}; // 34
        long res = instance.gettingTheDifferentNumber3(test);
        Assert.assertEquals(34, res);
    }

    @Test
    public void shouldReturnIntegerPlusOneIfArrayLengthIsOneForIntegerMaxValue(){
        int[] test = {Integer.MAX_VALUE}; // 34
        long res = instance.gettingTheDifferentNumber3(test);
        Assert.assertEquals((long)Integer.MAX_VALUE + 1, res);
    }

    @Test
    public void shouldReturnIntegerMinValueIfArrayIsEmpty(){
        int[] test = {};
        int res = instance.gettingTheDifferentNumber(test);
        Assert.assertEquals(Integer.MIN_VALUE, res);
    }
}