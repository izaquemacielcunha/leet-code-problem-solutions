package com.leetcode.problem.difficult.easy;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    private PalindromeNumber() {}

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int originalNumber = x;
            int reversedNumber = 0;
            while (x > 0) {
                int removedNumber = x % 10;
                reversedNumber = reversedNumber * 10 + removedNumber;
                x = x / 10;
            }
            return originalNumber == reversedNumber;
        }
    }
}// end of class
