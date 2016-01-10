package com.company;

import com.company.tests.TestArrayInvestigation;
import com.company.tests.TestMatrixInvestigation;

public class Main {
    public static void main(String[] args) throws Exception {
        new TestArrayInvestigation().demonstrateArrayInvestigation();

        new TestMatrixInvestigation().demonstrateMatrixInvestigation();
    }
}
