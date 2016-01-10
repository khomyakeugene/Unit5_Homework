package com.company.matrix;

import com.company.utils.Utils;

import java.text.MessageFormat;

/**
 * Created by Yevgen on 10.01.2016.
 */
public class MatrixCalculator {
    public final static String THE_SIZES_OF_TWO_MATRIX_MUST_BE_EQUAL = "The sizes of two matrices must be greater than zero and be equal!";
    public final static String THERE_ARE_LINES_WITH_DIFFERENT_LENGTH_IN_MATRIX = "There are lines with different length in matrix!";
    public final static String THE_WIDTH_OF_FIRST_MATRIX_IS_NOT_EQUAL_TO_THE_HEIGHT_OF_SECOND_MATRIX =
            "The width {0} of the first matrix is not equal to the height {1} of the second one!";

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
            throw new IllegalArgumentException(fullMethodName + ": " + THE_SIZES_OF_TWO_MATRIX_MUST_BE_EQUAL);
        }
    }


    public static int getMatrixHeight(double[][] matrix) {
        return matrix.length;
    }

    public static int getMatrixWidth(double[][] matrix) throws IllegalArgumentException {
        int width = -1;

        for (double[] line: matrix) {
            if (width == -1) {
                width = line.length;
            }
            else {
                if (line.length != width) {
                    String fullMethodName = Utils.getFullMethodName();
                    throw new IllegalArgumentException(fullMethodName + ": " + THERE_ARE_LINES_WITH_DIFFERENT_LENGTH_IN_MATRIX);
                }
            }
        }

        return width;
    }

    // Check if it is possible to multiply first matrix by second matrix
    public static void checkMatrixMultiplicationPossibility(double[][] firstOperand, double[][] secondOperand)
            throws IllegalArgumentException {

        int firstMatrixWidth = getMatrixWidth(firstOperand);
        int secondMatrixHeight = getMatrixHeight(secondOperand);
        if (firstMatrixWidth != secondMatrixHeight) {
            String fullMethodName = Utils.getFullMethodName();
            throw new IllegalArgumentException(fullMethodName + ": " +
                    MessageFormat.format(THE_WIDTH_OF_FIRST_MATRIX_IS_NOT_EQUAL_TO_THE_HEIGHT_OF_SECOND_MATRIX,
                            firstMatrixWidth, secondMatrixHeight));
        }
    }


    public static double round(double value, double decimalPower) {
        return Math.round(value  * decimalPower) / decimalPower;
    }

    private static double[][] addOrSub(double[][] firstOperand, double[][] secondOperand, int decimalPrecision, boolean isAddition) {
        // Check two matrix size equality
        checkMatrixSizeEquality(firstOperand, secondOperand);

        double[][] result = new double[getMatrixHeight(firstOperand)][getMatrixWidth(firstOperand)];

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

    public static double[][] multiplyByNumber(double[][] matrix, double number, int decimalPrecision) {
        double[][] result = new double[getMatrixHeight(matrix)][getMatrixWidth(matrix)];

        double decimalPower = Math.pow(10, decimalPrecision);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = round((matrix[i][j] * number), decimalPower);
            }
        }

        return result;
    }

    public static double[][] mul(double[][] firstOperand, double[][] secondOperand, int decimalPrecision) {
        // Check if it is possible to multiply first matrix by second matrix
        checkMatrixMultiplicationPossibility(firstOperand, secondOperand);

        int firstMatrixWidth = getMatrixWidth(firstOperand);
        int resultMatrixWidth = getMatrixWidth(secondOperand);
        int resultMatrixHeight = getMatrixHeight(firstOperand);
        double[][] result = new double[resultMatrixHeight][resultMatrixWidth];

        double decimalPower = Math.pow(10, decimalPrecision);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = 0.0;
                for (int k = 0; k < firstMatrixWidth; k++) {
                    result[i][j] += firstOperand[i][k] * secondOperand[k][j];
                }
                result[i][j] = round(result[i][j] , decimalPower);
            }
        }

        return result;
    }

    public static double[][] transpose(double[][] matrix, int decimalPrecision) {
        int resultMatrixWidth = getMatrixHeight(matrix);
        int resultMatrixHeight = getMatrixWidth(matrix);
        double[][] result = new double[resultMatrixHeight][resultMatrixWidth];

        double decimalPower = Math.pow(10, decimalPrecision); // ненужная строка?
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

}


