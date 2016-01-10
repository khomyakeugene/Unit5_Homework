package com.company.matrix;

import com.company.utils.Utils;

/**
 * Created by Yevgen on 10.01.2016.
 */
public class MatrixCalculator {
    public final static String THE_SIZES_OF_TWO_MATRIX_MUST_BE_EQUAL = "The sizes of two matrices must be greater than zero and be equal!";

    // Check two matrix size equality
    public static void checkMatrixSizeEquality(double[][] firstOperand, double[][] secondOperand)
            throws IllegalArgumentException {

        boolean isOk = (firstOperand != null) && (secondOperand != null) && (firstOperand.length == secondOperand.length);
        if (isOk) {
            for (int i = 0; i < firstOperand.length && isOk; i++) {
                isOk = firstOperand[i].length == secondOperand[i].length;
            }
        }
        if (!isOk) {
            String fullMethodName = Utils.getFullMethodName();
            throw new IllegalArgumentException(fullMethodName + ": " +THE_SIZES_OF_TWO_MATRIX_MUST_BE_EQUAL);
        }
    }

    public static double round(double value, double decimalPower) {
        return Math.round(value  * decimalPower) / decimalPower;
    }

    private static double[][] addOrSub(double[][] firstOperand, double[][] secondOperand, int decimalPrecision, boolean isAddition) {
        // Check two matrix size equality
        checkMatrixSizeEquality(firstOperand, secondOperand);

        double[][] result = new double[firstOperand.length][firstOperand[0].length];

        double decimalPower = Math.pow(10, decimalPrecision);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = round(isAddition ? (firstOperand[i][j] + secondOperand[i][j]) :
                        (firstOperand[i][j] - secondOperand[i][j]), decimalPower);
            }
        }

        return result;
    }

    public static double[][] add(double[][] firstOperand, double[][] secondOperand, int decimalPrecision) {
        return addOrSub(firstOperand, secondOperand, decimalPrecision, true);
    }

    public static double[][] sub(double[][] firstOperand, double[][] secondOperand, int decimalPrecision) {
        return addOrSub(firstOperand, secondOperand, decimalPrecision, false);
    }


    public static double[][] mul(double[][] firstOperand, double[][] secondOperand, int decimalPrecision) {
        return null;
    }

}


