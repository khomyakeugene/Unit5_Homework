package com.company.matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Yevgen on 02.02.2016 as a part of the project "Unit5_Homework".
 */
public class MatrixCalculatorTest {
    public static final int DECIMAL_PRECISION = 2;
    final static double[][] firstMatrix =
            {{1.68, -0.55, 4.85, 4.77}, {4.25, 5.28, 2.41, 9.08}, {4.59, 5.25, 1.22, 1.94}};
    final static double[][] secondMatrix =
            {{9.32, -0.38, 8.28, 6.01}, {4.51, 1.93, -4.51, 7.69}, {7.7, 5.06, 9.06, 2.88}};
    final static double[][] thirdMatrix =
            {{6.21, -5.29, 7.44, 0.86, -5.01}, {5.56, -3.01, -9.13, 9.9, -2.56}, {4.03, 4.27, 4.49, -4.06, 0.72},
                    {-6.57, 1.65, 0.91, 9.39, 8.63}};
    final static double[][] fourthMatrix =
            {{6.21, -5.29, 7.44, 0.86, -5.01}, {-7.0, -9.13, 9.9, -2.56}, {4.03, 4.27, 4.49, -4.06, 0.72},
                    {-6.57, 1.65, 0.91, 9.39, 8.63, 33.55}};
    final static double[][] addResult =
            {{11.0, -0.93, 13.13, 10.78}, {8.76, 7.21, -2.1, 16.77}, {12.29, 10.31, 10.28, 4.82}};
    final static double[][] subResult =
            {{-7.64, -0.17, -3.43, -1.24}, {-0.26, 3.35, 6.92, 1.39}, {-3.11, 0.19, -7.84, -0.94}};
    final static double mulNumber = 123.45;
    final static double[][] mulByNumberResult =
            {{207.4, -67.9, 598.73, 588.86}, {524.66, 651.82, 297.51, 1120.93}, {566.64, 648.11, 150.61, 239.49}};
    final static double[][] mulResult =
            {{-4.42, 21.35, 43.64, 21.1, 37.65}, {5.81, -13.1, 2.5, 131.4, 45.29}, {49.86, -31.67, -6.54, 69.19, -18.82}};
    final static double[][] transposeResult =
            {{1.68, 4.25, 4.59}, {-0.55, 5.28, 5.25}, {4.85, 2.41, 1.22}, {4.77, 9.08, 1.94}};

    static protected void assertMatrixEquals(double[][] expected, double[][] actual) {
        assertEquals(MatrixCalculator.getMatrixWidth(expected), MatrixCalculator.getMatrixWidth(actual));
        assertEquals(MatrixCalculator.getMatrixHeight(expected), MatrixCalculator.getMatrixHeight(actual));

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 0.0);
        }
    }

    @Test(expected = IllegalArgumentException.class, timeout = 1000)
    public void testCheckMatrixSizeEquality() throws Exception {
        MatrixCalculator.checkMatrixSizeEquality(firstMatrix, thirdMatrix);
    }

    @Test(timeout = 1000)
    public void testGetMatrixHeight() throws Exception {
        final Integer result = MatrixCalculator.getMatrixHeight(firstMatrix);

        final Integer expected = 3;
        assertEquals(expected, result);
    }

    @Test(timeout = 1000)
    public void testGetMatrixWidth() throws Exception {
        final Integer result = MatrixCalculator.getMatrixWidth(secondMatrix);

        final Integer expected = 4;
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class, timeout = 1000)
    public void testGetMatrixWidthIllegalDataCheck() throws Exception {
        final Integer result = MatrixCalculator.getMatrixWidth(fourthMatrix);

        final Integer expected = 4;
        assertEquals(expected, result);
    }


    @Test(timeout = 1000)
    public void testCheckMatrixMultiplicationPossibility() throws Exception {
        MatrixCalculator.checkMatrixMultiplicationPossibility(firstMatrix, thirdMatrix);
    }

    @Test(expected = IllegalArgumentException.class, timeout = 1000)
    public void testCheckMatrixMultiplicationPossibilityIllegalDataCheck() throws Exception {
        MatrixCalculator.checkMatrixMultiplicationPossibility(firstMatrix, secondMatrix);
    }

    @Test(timeout = 1000)
    public void testRound() throws Exception {
        final double value = 10.2387;
        final double decimalPower = 100.0;
        final Double result = MatrixCalculator.round(value, decimalPower);

        final Double expected = 10.24;
        assertEquals(expected, result);

    }

    @Test(timeout = 1000)
    public void testAdd() throws Exception {
        final double[][] result = MatrixCalculator.add(firstMatrix, secondMatrix, DECIMAL_PRECISION);

        assertMatrixEquals(addResult, result);
    }

    @Test(timeout = 1000)
    public void testSub() throws Exception {
        final double[][] result = MatrixCalculator.sub(firstMatrix, secondMatrix, DECIMAL_PRECISION);

        assertMatrixEquals(subResult, result);
    }

    @Test(timeout = 1000)
    public void testMultiplyByNumber() throws Exception {
        final double[][] result = MatrixCalculator.multiplyByNumber(firstMatrix, mulNumber, DECIMAL_PRECISION);

        assertMatrixEquals(mulByNumberResult, result);
    }

    @Test(timeout = 1000)
    public void testMul() throws Exception {
        final double[][] result = MatrixCalculator.mul(firstMatrix, thirdMatrix, DECIMAL_PRECISION);

        assertMatrixEquals(mulResult, result);
    }

    @Test(timeout = 1000)
    public void testTranspose() throws Exception {
        final double[][] result = MatrixCalculator.transpose(firstMatrix);

        assertMatrixEquals(transposeResult, result);
    }
}