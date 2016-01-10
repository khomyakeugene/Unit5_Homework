package com.company.tests;

import com.company.array.ArrayInvestigation;
import com.company.utils.Utils;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by Yevgen on 04.01.2016.
 */
public class TestArrayInvestigation {
    public static final String TEST_DATA_PATTERN = "Test data: {0}";
    public static final String MIN_VALUE_PATTERN = "Minimum value: {0}";
    public static final String MAX_VALUE_PATTERN = "Maximum value: {0}";
    public static final String SORTED_TEST_DATA_PATTERN = "Sorted test data: {0}";

    public static final int[] TEST_DATA = {17, 1, 2, 4, -78, 23, 5, 8, 12};
    // Reserve this "empty example" here to have the possibility to demonstrate "extreme case"
    // public static final int[] TEST_DATA = {};

    public void demonstrateArrayInvestigation() {
        try {
            // Show source array
            Utils.writeMessage(MessageFormat.format(TEST_DATA_PATTERN, Arrays.toString(TEST_DATA)));

            // Get minimum value from array and show it
            demonstrateGetMinValue();
            // Get maximum value from array and show it
            demonstrateGetMaxValue();
            // Sorting of array and show sorted array
            demonstrateSort();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void demonstrateGetMinValue() throws Exception {
        // Get minimum value from array and show it
        Utils.writeMessage(MessageFormat.format(MIN_VALUE_PATTERN, ArrayInvestigation.getMinValue(TEST_DATA)));
    }

    public void demonstrateGetMaxValue() throws Exception {
        // Get maximum value from array and show it
        Utils.writeMessage(MessageFormat.format(MAX_VALUE_PATTERN, ArrayInvestigation.getMaxValue(TEST_DATA)));
    }

    public void demonstrateSort() throws Exception {
        // Sorting of array
        ArrayInvestigation.sort(TEST_DATA);
        // Show sorted array
        Utils.writeMessage(MessageFormat.format(SORTED_TEST_DATA_PATTERN, Arrays.toString(TEST_DATA)));
    }
}
