package com.algorithm.string;

public class MaxLenBack {

    public static String getMaxLenBackStr(String str){
        if(str == null){
            return null;
        }
        if(str.length() == 1){
            return str;
        }
        if(str.length() == 2 && str.charAt(0) == str.charAt(1)){
            return str;
        }
        String res="";
        Integer maxLen=0;
        char[] crr = str.toCharArray();
        int len=crr.length;
        for(int i=1;i<len-2;i++){
            int l=i,r=i;
            while ((--l >= 0) &&(++r<=len-1) && (crr[l] == crr[r])) {
               int tmpLen = r-l;
               if(tmpLen>maxLen){
                   res = str.substring(l,r+1);
                   maxLen = tmpLen;
               }
            }

            int m=i,n=i+1;
            while(m>=0 && n<=len-1 && crr[m] ==crr[n]){
                int tmpLen = n-m;
                if(tmpLen>maxLen){
                    res = str.substring(m,n+1);
                    maxLen = tmpLen;
                }
                m--;n++;
            }
        }

        return res;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // abc => #a#b#c#
        String str = generateString(s);

        int[] palindrome = new int[str.length()];
        int mid = 0, longest = 1;
        palindrome[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            int len = 1;
            if (mid + longest > i) {
                int mirrorOfI = mid - (i - mid);
                len = Math.min(palindrome[mirrorOfI], mid + longest - i);
            }

            while (i + len < str.length() && i - len >= 0) {
                if (str.charAt(i - len) != str.charAt(i + len)) {
                    break;
                }
                len++;
            }

            if (len > longest) {
                longest = len;
                mid = i;
            }

            palindrome[i] = len;
        }

        longest = longest - 1; // remove the extra #
        int start = (mid - 1) / 2 - (longest - 1) / 2;
        return s.substring(start, start + longest);
    }

    private static String generateString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');

        return sb.toString();
    }

    public static void main(String[] args) {
        String reqStr = "zzabdbahhmmuummhh";
//        long s1 = System.currentTimeMillis();
//        String result = getMaxLenBackStr(reqStr);
//        long s2 = System.currentTimeMillis();
//        System.out.println(result+"==="+(s2-s1));
        long s3 = System.currentTimeMillis();
        String result2 = longestPalindrome(reqStr);
        long s4 = System.currentTimeMillis();
        System.out.println(result2+"==="+(s4-s3));

    }
}
