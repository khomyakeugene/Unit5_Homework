package com.company.array;

import com.company.utils.Utils;

/**
 * Created by Yevgen on 04.01.2016.
 */
public class ArrayInvestigation {
    public static final String ARRAY_IS_EMPTY_MESSAGE = "Array is empty!";
    protected enum ConditionType {MIN_VALUE, MAX_VALUE}

    public static void throwArrayIsEmptyException() throws Exception {
        String methodName = Utils.getFullMethodName();

        Utils.throwTextException(methodName, ARRAY_IS_EMPTY_MESSAGE);
    }

    protected static int getValueByCondition(int[] data, ConditionType conditionType) throws Exception {
        int resultValue = (conditionType == ConditionType.MIN_VALUE) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        if (data.length > 0) {
            resultValue = data[0];
            for (int element: data) {
                // Use the "switch" here only as an occasion to show "traditional method" of using the "enum type"
                switch (conditionType) {
                    case MIN_VALUE:
                        if (element < resultValue) {
                            resultValue = element;
                        }
                        break;

                    case MAX_VALUE:
                        if (element > resultValue) {
                            resultValue = element;
                        }
                        break;
                }
            }
        }
        else {
            throwArrayIsEmptyException();
        }

        return resultValue;
    }

    public static int getMaxValue(int[] data) throws Exception {
        return getValueByCondition(data, ConditionType.MAX_VALUE);
     }

    public static int getMinValue(int[] data) throws Exception {
        return getValueByCondition(data, ConditionType.MIN_VALUE);
    }

    public static void sort(int[] data) {
        // Use "Bubble Sort Algorithm" as one of possible methods
        bubbleSort(data);
    }

    // Implementing of "Bubble Sort Algorithm"
    public static void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
