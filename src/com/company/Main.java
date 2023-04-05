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
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        //다이나믹 프로그래밍 점화식: sum[i] = sum[i - 1] + sequence[i], i까지의 합중 가장 큰값 더하기
        long[] sum = new long[sequence.length + 1];
        for (int i = 1; i < sum.length; i++) {
            if (i % 2 == 0) {
                sum[i] = sum[i - 1] + sequence[i - 1];
            } else {
                sum[i] = sum[i - 1] + sequence[i - 1] * -1;
            }
        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < sum.length; i++) {
            max = Math.max(max, sum[i]);
            min = Math.min(min, sum[i]);
        }
        long answer= max - min;
        System.out.println(answer);
    }
}

