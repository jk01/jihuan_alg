package com.algorithm.string;

public class StrValidCircle {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isvalid(s.charAt(front))) { // nead to check range of a/b
                front++;
            }

            if (front == s.length()) { // for empty string “.,,,”
                return true;
            }

            while (end >= 0 && ! isvalid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                front++;
                end--;
            }
        }

        return end <= front;
    }

    private static boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean res = isPalindrome(str);
        System.out.println(res);
    }

}
