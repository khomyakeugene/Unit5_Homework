package com.company.utils;

import java.text.MessageFormat;

/**
 * Created by Yevgen on 06.01.2016.
 */

public class Utils {
    public final static int LETS_THINK_THIS_IS_THE_NUMBER_OF_CALLING_ELEMENT_OF_STACK = 2;

    public final static String FULL_METHOD_NAME_PATTERN = "{0}.{1}";
    public final static String EXCEPTION_MESSAGE_PATTERN = "{0}: {1}";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void throwTextException(String methodName, String text) throws Exception {
        throw new Exception(MessageFormat.format(EXCEPTION_MESSAGE_PATTERN, methodName, text));
    }

    public static String getFullMethodName() {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();

        return MessageFormat.format(
                FULL_METHOD_NAME_PATTERN,
                stackTraceElement[LETS_THINK_THIS_IS_THE_NUMBER_OF_CALLING_ELEMENT_OF_STACK].getClassName(),
                stackTraceElement[LETS_THINK_THIS_IS_THE_NUMBER_OF_CALLING_ELEMENT_OF_STACK].getMethodName());
    }


}