package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution s = new Solution();
        s.solution();
    }
}

class Solution {

    public void solution() {
        String s = "abcdcba";

        int answer = 1;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = true;
        }

        for (int i = 0; i < n - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 2))
                dp[i][i + 2] = true;
        }

        for (int len = 4; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    answer = len;
                }
            }
        }
        System.out.println(answer);
    }
}

