package com.company;

import com.company.tests.TestArrayInvestigation;
import com.company.tests.TestMatrixInvestigation;

public class Main {
    public static void main(String[] args) throws Exception { //желательно не выпускать эксепшн из программы, а ловить и обрабатывать его,
        //чтобы программа завершалась без ошибок.
        new TestArrayInvestigation().demonstrateArrayInvestigation();

        // Additional task of Unit 5
        new TestMatrixInvestigation().demonstrateMatrixInvestigation();
    }
}
