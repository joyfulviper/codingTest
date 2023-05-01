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
        int answer = 0;
        long[] dp = new long[5001];
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;
        dp[4] = 11;
        //dp[6] = dp[4] * dp[2] + dp[2] * 2 + 2
        //dp[8] = dp[6] * dp[2] + dp[4] * 2 + dp[2] * 2 + 2
        for (int i = 6; i <= 5000; i+=2) {
            dp[i] = dp[i - 2] * dp[2];
            for (int j = 4; j < i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
            dp[i] += 2;
            dp[i] %= 1000000007;
        }
        answer = (int) dp[8];
        System.out.println(dp[8]);
    }
}

