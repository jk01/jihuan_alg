package com.algorithm.string;

public class TwoStrMatch {

    public static boolean isMatch(String ss, String pp) {
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int m = s.length;
        int n = p.length;
        boolean[][] f = new boolean[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; ++i) {
            for (j = 0; j <= n; ++j) {
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                    System.out.print(f[i][j]+"("+i+","+j+"),");
                    continue;
                }

                if (j == 0) {
                    f[i][j] = false;
                    System.out.print(f[i][j]+"("+i+","+j+"),");
                    continue;
                }

                f[i][j] = false;
                if (p[j - 1] != '*') {
                    if (i > 0 && (p[j - 1] == '?' || p[j - 1] == s[i - 1])) {
                        f[i][j] = f[i-1][j-1];
                    }
                }else {
                    f[i][j] = f[i][j - 1];
                    if (i > 0) f[i][j] |= f[i - 1][j];
                }
                System.out.print(f[i][j]+"("+i+","+j+"),");
            }
            System.out.println();
        }
        return f[m][n];
    }

    public static void main(String[] args) {
        String ss ="abc";
        String pp = "a*";
        boolean res = isMatch(ss, pp);
        System.out.println(res);
    }

}
