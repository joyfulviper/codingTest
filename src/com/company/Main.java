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
        int r1 = 2;
        int r2 = 5;

        long answer = 0;
        for (int i = 1; i <= r2; i++) {
            long start = (long) Math.ceil(Math.sqrt((long) r1 * r1 - (long) i * i)); // 작은 원 바깥쪽
            long end = (long) Math.floor(Math.sqrt((long) r2 * r2 - (long) i * i));// 큰 원 안쪽
            answer += (end - start) + 1;
        }
        answer *= 4;
        System.out.println(answer);

    }
}

