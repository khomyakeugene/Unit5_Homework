package com.company.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Yevgen on 02.02.2016 as a part of the project "Unit5_Homework".
 */

public class ArrayInvestigationTest {
    final int[] sourceArray = {17, 1, 2, 4, -78, 23, 5, 8, 12};

    @Test (timeout = 1000)
    public void testGetMaxValue() throws Exception {
        final Integer result = ArrayInvestigation.getMaxValue(sourceArray);

        final Integer expected = 23;
        assertEquals(expected, result);
    }

    @Test(timeout = 1000)
    public void testGetMinValue() throws Exception {
        final Integer result = ArrayInvestigation.getMinValue(sourceArray);

        final Integer expected = -78;
        assertEquals(expected, result);
    }

    @Test (timeout = 1000)
    public void testSort() throws Exception {
        ArrayInvestigation.sort(sourceArray);

        final int[] expected = {-78, 1, 2, 4, 5, 8, 12, 17, 23};
        assertArrayEquals(expected, sourceArray);
    }
}