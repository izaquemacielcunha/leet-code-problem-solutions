package com.leetcode.problem.difficult.easy;

import java.util.*;

public class RomanToInteger {

    private RomanToInteger() {}

    public static int romanToInt(String s) {
        Iterator<String> iterator = convertStringToList(s).iterator();

        int sum = 0;
        RomanNumber currentRomanNumber = null;
        RomanNumber nextRomanNumber = null;
        boolean keepNextNumber = false;

        while (iterator.hasNext()) {
            if (keepNextNumber) {
                currentRomanNumber = nextRomanNumber;
            } else {
                currentRomanNumber = RomanNumber.toRomanNumber(iterator.next());
            }
            if (!iterator.hasNext()) {
                sum += currentRomanNumber.getValue();
                break;
            }
            nextRomanNumber = RomanNumber.toRomanNumber(iterator.next());

            if (currentRomanNumber.getValue() < nextRomanNumber.getValue()) {
                sum += nextRomanNumber.getValue() - currentRomanNumber.getValue();
                keepNextNumber = false;
            } else {
                sum += currentRomanNumber.getValue();
                keepNextNumber = true;
                if (!iterator.hasNext()) {
                    sum += nextRomanNumber.getValue();
                }
            }
        }

        return sum;
    }

    private static List<String> convertStringToList(String value) {
        List<String> list = new ArrayList<>();
        char[] tokens = value.toCharArray();
        for (char token : tokens) {
            list.add(String.valueOf(token));
        }
        return list;
    }

    enum RomanNumber {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private final int value;

        RomanNumber(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static RomanNumber toRomanNumber(String number) {
            for (RomanNumber romanNumber : RomanNumber.values()) {
                if (romanNumber.name().equalsIgnoreCase(number)) {
                    return romanNumber;
                }
            }
            throw new IllegalArgumentException("Invalid Roman Number. Number = " + number);
        }
    }
}