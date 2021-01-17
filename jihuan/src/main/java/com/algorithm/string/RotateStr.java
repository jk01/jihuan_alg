package com.algorithm.string;

public class RotateStr {

    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0)
            return;

        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    private void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

    public String RotateString2(String str, int left, int right) {
        // write your code here
        if(str.length() == 0) return str;
        int len = str.length();
        int offset = left - right;    	//计算总偏移量
        int flag = offset >= 0 ? 1 : -1;
        String results = new String();
        String A = new String();
        String B = new String();
        offset = Math.abs(offset) % len;
        if(flag >= 0){
            A = str.substring(0,offset);	//截取offset左边部分
            B = str.substring(offset,len);	//截取offset右边部分
        }
        else{
            A = str.substring(0,len - offset);	//截取右边算起offset位置处左边部分
            B = str.substring(len - offset,len);	 //截取其右边部分
        }
        results = B.concat(A);
        return results;
    }
}
