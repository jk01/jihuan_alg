package com.algorithm.string;

public class KDistMaxLength {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int[] cnt = new int[256];
        char[] sc = s.toCharArray();

        int ans = 0;
        int sum = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            cnt[sc[r]]++;
            if (cnt[sc[r]] == 1) {
                sum++;
            }
            while (sum > k) {
                cnt[sc[l]]--;
                if (cnt[sc[l]] == 0) {
                    sum--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static long kDistinctCharacters(String s, int k) {
        // Write your code here
        int[] cnt = new int[26];
        int count = 0;
        int l = 0, r = 0;
        long ans = 0;
        int len = s.length();
        while (l <= r && l < len) {
            while (count < k && r < len) {
                cnt[s.charAt(r) - 'a']++;
                if (cnt[s.charAt(r) - 'a'] == 1) {
                    count++;
                }
                r++;
            }
            if (count == k) {
                ans += len - r + 1;
            }
            if (cnt[s.charAt(l) - 'a'] == 1) {
                count--;
            }
            cnt[s.charAt(l) - 'a']--;
            l++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String req = "abc";
//        System.out.println(lengthOfLongestSubstringKDistinct(req,1));
        System.out.println(kDistinctCharacters(req,1));
    }
}
