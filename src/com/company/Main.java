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
        int n = 5;
        long[] dp = new long[n + 1];
        int[] money = {1, 2, 5};
        for (int i = 0; i <= n; i++) {
            if(i % money[0] == 0) {
                dp[i] = 1;
            }
        }
        for (int i = 1; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                dp[j] += dp[j - money[i]];
            }
            dp[i] %=  1000000007;
        }
        System.out.println(dp[n]);
    }
}

