package com.company.tests;

import com.company.matrix.MatrixCalculator;
import com.company.utils.Utils;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by Yevgen on 10.01.2016.
 */
public class TestMatrixInvestigation {
    public final static String SOURCE_MATRIX_PATTERN = "The {0} source matrix:";
    public final static String FIRST_MESSAGE = "first";
    public final static String SECOND_MESSAGE = "second";
    public final static String THIRD_MESSAGE = "third";
    public final static String SUM_OF_TWO_MATRIX_MESSAGE = "The sum of the {0} and the {1} matrices:";
    public final static String DIFFERENCE_OF_TWO_MATRIX_MESSAGE = "The difference between the {0} and the {1} matrices:";
    public final static String MULTIPLY_BY_NUMBER_PATTERN = "The result of multiplication of the {0} matrix by number {1}:";
    public final static String MULTIPLY_MATRIX_BY_MATRIX_PATTERN = "The result of multiplication of the {0} matrix by the {1} matrix:";
    public final static String TRANSPOSE_MATRIX_PATTERN = "The result of transposition of the {0} matrix:";

    public static final int MATRIX_WIDTH = 4;
    public static final int MATRIX_HEIGHT = 3;
    public static final int THIRD_MATRIX_WIDTH = 5;
    public static final int THIRD_MATRIX_HEIGHT = MATRIX_WIDTH;
    public static final double UPPER_LIMIT = 10.0;
    public static final int DECIMAL_PRECISION = 2;

    public static final double NEGATIVE_RELATIVE_DENSITY = 0.3;
    public static final double MULTIPLY_COEFFICIENT = 123.45;

    public double firstMatrix[][];
    public double secondMatrix[][];
    public double thirdMatrix[][];

    public double[][] generateRandomizeMatrixData(int width, int height) {
        double matrix[][] = new double[height][width];

        double decimalPower = Math.pow(10, DECIMAL_PRECISION);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = MatrixCalculator.round(Math.random() * UPPER_LIMIT, decimalPower);
                // Add possible negative sign
                if (Math.random() < NEGATIVE_RELATIVE_DENSITY) {
                    matrix[i][j] = -matrix[i][j];
                }
            }
        }

        return matrix;
    }

    // Prepare test data
    public void initData() {
        firstMatrix = generateRandomizeMatrixData(MATRIX_WIDTH, MATRIX_HEIGHT);
        secondMatrix = generateRandomizeMatrixData(MATRIX_WIDTH, MATRIX_HEIGHT);
        thirdMatrix = generateRandomizeMatrixData(THIRD_MATRIX_WIDTH, THIRD_MATRIX_HEIGHT);
    }

    public void writeMatrix(double[][] matrix, String header) {
        Utils.writeMessage(header);

        for (double[] line: matrix) {
            Utils.writeMessage(Arrays.toString(line));
        }
    }

    // Show source data
    public void showSourceData() {
        writeMatrix(firstMatrix, MessageFormat.format(SOURCE_MATRIX_PATTERN, FIRST_MESSAGE));
        writeMatrix(secondMatrix, MessageFormat.format(SOURCE_MATRIX_PATTERN, SECOND_MESSAGE));
        writeMatrix(thirdMatrix, MessageFormat.format(SOURCE_MATRIX_PATTERN, THIRD_MESSAGE));
    }

    public void demonstrateMatrixInvestigation() {
        // Prepare test data
        initData();
        // Show source data
        showSourceData();

        // Show sum of two matrices
        demonstrateMatrixSum();
        // Show difference of two matrices
        demonstrateMatrixDifference();
        // Show multiplication by number
        demonstrateMatrixMultiplicationByNumber();
        // Show multiplication matrix by matrix
        demonstrateMatrixByMatrixMultiplication();
        // Show transposition of matrix
        demonstrateMatrixTransposition();
    }

    // Show sum of two matrices
    public void demonstrateMatrixSum() {
        // Sum of two matrices
        writeMatrix(MatrixCalculator.add(firstMatrix, secondMatrix, DECIMAL_PRECISION),
                MessageFormat.format(SUM_OF_TWO_MATRIX_MESSAGE, FIRST_MESSAGE, SECOND_MESSAGE));
    }

    // Show difference of two matrices
    public void demonstrateMatrixDifference() {
        // Difference of two matrices
        writeMatrix(MatrixCalculator.sub(firstMatrix, secondMatrix, DECIMAL_PRECISION),
                MessageFormat.format(DIFFERENCE_OF_TWO_MATRIX_MESSAGE, FIRST_MESSAGE, SECOND_MESSAGE));
    }

    // Show multiplication by number
    public void demonstrateMatrixMultiplicationByNumber() {
        // Multiplication by number
        writeMatrix(MatrixCalculator.multiplyByNumber(firstMatrix, MULTIPLY_COEFFICIENT, DECIMAL_PRECISION),
                MessageFormat.format(MULTIPLY_BY_NUMBER_PATTERN, FIRST_MESSAGE, MULTIPLY_COEFFICIENT));
    }

    // Show multiplication matrix by matrix
    public void demonstrateMatrixByMatrixMultiplication() {
        // Matrix by matrix multiplication
        writeMatrix(MatrixCalculator.mul(firstMatrix, thirdMatrix, DECIMAL_PRECISION),
                MessageFormat.format(MULTIPLY_MATRIX_BY_MATRIX_PATTERN, FIRST_MESSAGE, THIRD_MESSAGE));
    }

    // Show transposition of matrix
    public void demonstrateMatrixTransposition() {
        // Transposition of matrix
        writeMatrix(MatrixCalculator.transpose(firstMatrix, DECIMAL_PRECISION),
                MessageFormat.format(TRANSPOSE_MATRIX_PATTERN, FIRST_MESSAGE));
    }

}
