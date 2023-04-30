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
        int target = 513;
        Set<Integer> set = new HashSet<>();

        int[][] dp = new int[100001][2];
        set.add(50);
        for (int i = 1; i <= 20; i++) {
            set.add(i);
            set.add(i * 2);
            set.add(i * 3);
        }
        for (int i = 1; i <= target; i++) {
            if (set.contains(i)) {
                dp[i][0] = 1;
                if (i <= 20 || i == 50) {
                    dp[i][1] = 1;
                } else {
                    dp[i][1] = 0;
                }
            } else {
                if (i <= 40 || i > 50) {
                    dp[i][0] = 2;
                    dp[i][1] = 2;
                } else {
                    dp[i][0] = 2;
                    dp[i][1] = 1;
                }
            }
        }

        for (int i = 61; i <= 100000; i++) {
            if (dp[i - 50][0] <= dp[i - 60][0]) {
                dp[i][0] = dp[i - 50][0] + 1;
                dp[i][1] = dp[i - 50][1] + 1;
            } else {
                dp[i][0] = dp[i - 60][0] + 1;
                dp[i][1] = dp[i - 60][1];
            }
        }

        System.out.println(dp[target][0] + "," + dp[target][1]);
    }
}

