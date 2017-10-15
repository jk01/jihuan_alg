package com.algorithm;

/**
 * Title: Divide Two Integers 两个数的除法
 * Description: 该类的功能
 题目

 两个整数相除

 将两个整数相除，要求不使用乘法、除法和 mod 运算符。

 如果溢出，返回 2147483647 。

 样例
 给定被除数 = 100 ，除数 = 9，返回 11

 解题

 15%的通过率，减法，位运算？表示不知道如何下手。
 * @author jihuan
 * @create 2017-10-15 22:13
 * @version: 1.0
 */
public class Solution12 {

    /**
     * 法一：利用减法，超时，人工直接去除的一些情况太流氓。
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide1(int dividend, int divisor) {
        // Write your code here
        if(dividend == 0)
            return 0;
        if(dividend == divisor)
            return 1;
        int count = 0;
        int flag1 = 1;
        int flag2 = 1;
        if(dividend == Integer.MIN_VALUE && divisor ==1)
            return dividend;
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return 2147483647;
        if(dividend<0){
            flag1 = -1;
            dividend = -dividend;
        }
        if(divisor<0){
            flag2 = -1;
            divisor = -divisor;
        }
        // dividend = 2147483647;
        // divisor = 2;
        if(divisor == 1)
            return dividend*flag1*flag2;
        while(dividend >= divisor){
            dividend -= divisor;
            count +=1;
        }
        return count*flag1*flag2;
    }

    /**
     * 法二：批量减法，参考博客，但是还是超市，除数是1的时候超时，是1的时候我单独处理，是2的时候超时
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide2(int dividend, int divisor) {
        // Write your code here
        if(dividend == 0)
            return 0;
        if(dividend == divisor)
            return 1;
        int count = 0;
        int flag1 = 1;
        int flag2 = 1;
        if(dividend == Integer.MIN_VALUE && divisor ==1)
            return dividend;
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return 2147483647;
        if(dividend<0){
            flag1 = -1;
            dividend = -dividend;
        }
        if(divisor<0){
            flag2 = -1;
            divisor = -divisor;
        }
        // dividend = 2147483647;
        // divisor = 2;
        if(divisor == 1)
            return dividend*flag1*flag2;

        while(dividend >= divisor){
            int sum = divisor;
            int count1 = 1;
            while(sum + sum <= dividend){
                count1 += count1;
                sum += sum;
            }
            dividend -= sum;
            count += count1;
        }
        return count*flag1*flag2;
    }

    /**
     * 利用位运算
     参考博客，感觉与法二很像的，我把二中减肥换成位运算，也是运行超时，我不理解，直接用他的程序就可以通过。
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide3(int dividend, int divisor) {
        // Write your code here
        if(divisor ==0)
            return Integer.MAX_VALUE;
        if(divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        int count = 0;
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
        while(pDividend >= pDivisor){
            int count1 = 0;
            while((pDivisor<<count1)<= pDividend){
                count1++;
            }
            count += 1<<(count1 - 1);
            pDividend -=(pDivisor<<(count1 - 1));
        }
        if( dividend >0 && divisor >0 || dividend<0 && divisor<0)
            return count;
        else
            return -count;
    }
    //博客中的位运算改成减法的也可以通过，就是我自己搞的减法的就是能通过，无法理解
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if(divisor ==0)
            return Integer.MAX_VALUE;
        if(divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        int count = 0;
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
        while(pDividend >= pDivisor){
            int count1 = 1;
            long sum = pDivisor;
            while(( sum + sum)<= pDividend){
                count1 += count1;
                sum +=sum;
            }
            count += count1;
            pDividend -= sum;
        }
        if( dividend >0 && divisor >0 || dividend<0 && divisor<0)
            return count;
        else
            return -count;
    }
}
