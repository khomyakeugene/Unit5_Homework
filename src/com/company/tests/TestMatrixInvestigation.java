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
    public final static String SUM_OF_TWO_MATRIX_MESSAGE = "The sum of two matrices:";

    public static final int MATRIX_WIDTH = 4;
    public static final int MATRIX_HEIGHT = 3;
    public static final double UPPER_LIMIT = 10.0;
    public static final int DECIMAL_PRECISION = 2;
    public static final double NEGATIVE_RELATIVE_DENSITY = 0.3;

    public double firstMatrix[][];
    public double secondMatrix[][];

    public double[][] generateRandomizeMatrixData(int width, int height) {
        double matrix[][] = new double[height][width];

        double decimalPower = Math.pow(10, DECIMAL_PRECISION);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.round((Math.random() * UPPER_LIMIT) * decimalPower) / decimalPower;
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
    }

    public void demonstrateMatrixInvestigation() throws Exception {
        // Prepare test data
        initData();
        // Show source data
        showSourceData();

        // Show sum of two matrices
        demonstrateMatrixSum();
    }

    // Show sum of two matrices
    public void demonstrateMatrixSum() {
        // Sum of two matrices
        writeMatrix(MatrixCalculator.add(firstMatrix, secondMatrix, DECIMAL_PRECISION), SUM_OF_TWO_MATRIX_MESSAGE);
    }
}
