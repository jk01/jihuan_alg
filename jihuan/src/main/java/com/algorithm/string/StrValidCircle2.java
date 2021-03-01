package com.algorithm.string;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class StrValidCircle2 {
    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }

        if (left >= right) {
            return true;
        }

        return isSubPalindrome(s, left + 1, right) || isSubPalindrome(s, left, right - 1);
    }

    private static boolean isSubPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String str = "abca";
        boolean res = validPalindrome(str);
        System.out.println(res);
        ArrayBlockingQueue a = new ArrayBlockingQueue(10);
        a.add(null);
        a.offer(null);
        a.put(null);
        a.poll();
        a.poll(10L, TimeUnit.HOURS);
        a.take();
        LinkedBlockingQueue b = new LinkedBlockingQueue();
        b.add(null);
        b.offer(null);
        b.offer(null, 3L, TimeUnit.HOURS);
        b.put(null);
        b.take();
        b.poll();
        b.poll(3L,TimeUnit.SECONDS);
    }

}
