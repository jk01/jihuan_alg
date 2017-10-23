package com.algorithm;

/**
 * Title: 类的主题（开发人员填写）
 * Description: 该类的功能
 题目
 交叉字符串
 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 样例
 比如 s1 = "aabcc" s2 = "dbbca"
 - 当 s3 = "aadbbcbcac"，返回  true.
 - 当 s3 = "aadbbbaccc"， 返回 false.
 挑战
 要求时间复杂度为O(n^2)或者更好
 解题
 交叉比较，不能够AC
 参考这里的程序，直接运行原程序，在自己的基础上进行修改运行到78%测试数据的时候还是错了
 这里给了几种失败的方法
 下面只有选择动态规划来解题了
 动态规划矩阵matched[l1][l2]表示s1取l1长度（最后一个字母的pos是l1-1)，s2取l2长度(最后一个字母的pos是l2-1)，是否能匹配s3的l1+12长度。
 那么，我们有
 matched[l1][l2] = s1[l1-1] == s3[l1+l2-1] && matched[l1-1][l2] || s2[l2 - 1] == s3[l1+l2-1] && matched[l1][l2-1]
 边界条件是，其中一个长度为0，另一个去匹配s3.
 */
public class Solution4 {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if(s1.length() + s2.length() != s3.length())
            return false;
        // if(s1.equals("")&& s2.equals(s3))
        //     return true;
        // if(s2.equals("")&&s1.equals(s3))
        //     return true;
        boolean[][] matched= new boolean[s1.length()+1][s2.length()+1];
        matched[0][0]= true;
        for(int i1=1;i1<= s1.length(); i1++){
            if(s3.charAt(i1-1) == s1.charAt(i1-1))
                matched[i1][0] = true;
        }
        for(int i2= 1;i2<= s2.length();i2++){
            if(s3.charAt(i2-1) == s2.charAt(i2-1))
                matched[0][i2] = true;
        }
        for(int i1=1;i1<=s1.length(); i1++){
            char c1 = s1.charAt(i1-1);
            for(int i2 = 1;i2<= s2.length();i2++){
                int i3 = i1+ i2;
                char c2 = s2.charAt(i2- 1);
                char c3 = s3.charAt(i3 -1);
                if(c1 == c3)
                    matched[i1][i2] =matched[i1][i2] || matched[i1-1][i2];
                if( c2== c3)
                    matched[i1][i2] = matched[i1][i2] || matched[i1][i2-1];

            }
        }
        return matched[s1.length()][s2.length()];
    }

    /**
     *
     遍历s3的每个字符，这个字符必须是s1或s2中的字符;
     用i、j、k表示 s1、s2、s3字符下标；
     如果s3中的字符为s1中的字符，则i++，如果为s2中的字符则j++；
     这个字符如果s1和s2中都有，需要考虑两种情况，（i++,j不变）||（i不变,j++）；
     *
     */
    public static boolean isInterleave2(String str1,String str2,String str3){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        char[] s3 = str3.toCharArray();
        int len_1 = str1.length();
        int len_2 = str2.length();
        int len_3 = str3.length();
        if(len_1 + len_2 != len_3){
            return false;
        }
        int i= 0 ,j = 0;
        for (int k=0 ; k<len_3 ; k++){
            if(i>len_1)
                return false;
            if(j>len_2)
                return false;
            char temp = s3[k];
            //如果是s1中的字符，则m1为true
            boolean m1 = i<len_1 && temp == s1[i];
            //如果是s2中的字符,则m2为true
            boolean m2 = j<len_2 && temp == s2[j];
            if( !m1 && !m2 ){
                return false;
            }else if( m1 && m2 ){//即为s1中的字符也为s2中的字符,这里需要考虑两种情况
                String newS3 = str3.substring(k+1);
                return isInterleave2(str1.substring(i + 1), str2.substring(j), newS3)
                        || isInterleave2(str1.substring(i), str2.substring(j + 1), newS3);
            }else if(m1){
                i++;
            }else{
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       String s1 = "1234" ;
       String s2 = "1abcd";
       String s3 = "112abc34d";
//       Boolean b= isInterleave(s1,s2,s3);
       Boolean b2= isInterleave2(s1,s2,s3);
       System.out.println("result1=,result2="+b2);
    }
}
