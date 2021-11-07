package com.sbrf.reboot;

public class Calculator {
    public static int getAddition(int a, int b) {
        return a + b;
    }

    public static int getSubtraction(int a, int b) {
        return a - b;
    }

    public static int getMultiplication(int a, int b) {
        return a * b;
    }

    public static double getDivision(double a, double b) {
        return a / b;
    }

    public static int getFloorDiv(int a, int b) {
        return Math.floorDiv(a, b);
    }

    public static double getSquare(double a) {
        return a * a;
    }
}
