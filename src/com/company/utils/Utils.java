package com.company.utils;

import java.text.MessageFormat;

/**
 * Created by Yevgen on 03.01.2016.
 */
public class Utils {
    public final static int LETS_THINK_THIS_IS_THE_NUMBER_OF_CURRENT_ELEMENT_OF_STACK = 1;
    public final static int LETS_THINK_THIS_IS_THE_NUMBER_OF_CALLING_ELEMENT_OF_STACK = 2;

    public final static String CLASS_NAME_PATTERN = "Class Name: {0}";
    public final static String FULL_METHOD_NAME_PATTERN = "{0}.{1}";
    public final static String EXCEPTION_MESSAGE_PATTERN = "{0}: {1}";

    public static String getClassNameMessage(Object object) {
        return MessageFormat.format(CLASS_NAME_PATTERN, object.getClass().getName());
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String getClassName() {
        return Thread.currentThread().getStackTrace()[
                LETS_THINK_THIS_IS_THE_NUMBER_OF_CALLING_ELEMENT_OF_STACK].getClassName();
    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[
                LETS_THINK_THIS_IS_THE_NUMBER_OF_CALLING_ELEMENT_OF_STACK].getMethodName();
    }

    public static String getFullMethodName() {
        StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();

        return MessageFormat.format(
                FULL_METHOD_NAME_PATTERN,
                stackTraceElement[LETS_THINK_THIS_IS_THE_NUMBER_OF_CALLING_ELEMENT_OF_STACK].getClassName(),
                stackTraceElement[LETS_THINK_THIS_IS_THE_NUMBER_OF_CALLING_ELEMENT_OF_STACK].getMethodName());
    }

    public static String getFullMethodName(String className, String methodName) {
        return MessageFormat.format(FULL_METHOD_NAME_PATTERN, className, methodName);
    }

    public static void throwTextException(String methodName, String text) throws Exception {
        throw new Exception(MessageFormat.format(EXCEPTION_MESSAGE_PATTERN, methodName, text));
    }
}
