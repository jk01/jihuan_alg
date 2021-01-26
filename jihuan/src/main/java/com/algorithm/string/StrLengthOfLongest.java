package com.algorithm.string;

public class StrLengthOfLongest {
    public static int lengthOfLongestSubstring(String s) {
        // write your code here
        int[] cnt = new int[256];
        char[] sc = s.toCharArray();

        int ans = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            cnt[sc[r]]++;
            while (cnt[sc[r]] > 1) {
                cnt[sc[l]]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String aa = "abcdaddfsw";
        System.out.println(lengthOfLongestSubstring(aa));
    }
}
