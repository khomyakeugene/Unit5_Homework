package com.company.array;

import com.company.utils.Utils;

/**
 * Created by Yevgen on 04.01.2016.
 */
public class ArrayInvestigation {
    public static final String ARRAY_IS_EMPTY_MESSAGE = "Array is empty!";
    protected enum ConditionType {MIN_VALUE, MAX_VALUE}; //ненужные символы ИДЕА подсказывает.

    public static void trowArrayIsEmptyException() throws Exception { //ошибка в первом слове наименования метода
        String methodName = Utils.getFullMethodName();

        Utils.throwTextException(methodName, ARRAY_IS_EMPTY_MESSAGE);
    } //Что-то мне показалось запутанным так использовать исключения. Почему бы просто не вызывать стандартные, обрабатывать их где надо.
    // А если нужен кастомный, то создать его отдельным классом, где и принимать нужный месседж для выведения в консоль.
    //Сам стектрейс будет и так показывать класс и метод, где случился эксепшн.

    protected static int getValueByCondition(int[] data, ConditionType conditionType) throws Exception {
        int resultValue = (conditionType == ConditionType.MIN_VALUE) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        int arrayLength = data.length;

        if (arrayLength > 0) {
            resultValue = data[0];
            for (int i = 0; i < arrayLength; i++) { //ИДЕА предлагает использовать цикл for-each
                // Use the "switch" here only as an occasion to show "traditional method" of using the "enum type"
                switch (conditionType) {
                    case MIN_VALUE:
                        if (data[i] < resultValue) {
                            resultValue = data[i];
                        }
                        break;

                    case MAX_VALUE:
                        if (data[i] > resultValue) {
                            resultValue = data[i];
                        }
                        break;
                }
            }
        }
        else {
            trowArrayIsEmptyException();
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
