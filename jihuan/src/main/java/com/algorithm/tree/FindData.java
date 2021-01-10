package com.algorithm.tree;

public class FindData {
    public int[] getNumbers(int n) {
        int[] result = new int[2];

        if(n < 0)
        {
            return new int[]{};
        }
        if(n < 1)
        {
            return new int[]{1};
        }
        int a = 0;
        int b = 1;
        int c = 1;

        while(c < n)
        {
            int temp = b + c;
            a = b;
            b = c;
            c = temp;
        }

        if(c == n)
        {
            result[0] = b;
            result[1] = b + c;
            return result;
        }

        if(b == n)
        {
            result[0] = a;
            result[1] = c;
            return result;
        }

        result[0] = b;
        result[1] = c;
        return result;
    }
}
