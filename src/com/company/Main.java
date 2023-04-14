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
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};

        Arrays.sort(targets, (o1, o2) -> Integer.compare(o2[0], o1[0]));

        int start = targets[0][0];

        int answer = 1;
        for (int i = 1; i <targets.length; i++) {
            int[] target = targets[i];

            int nowStart = target[0];
            int nowEnd = target[1];

            if (nowEnd <= start) {
                answer++;
                start = nowStart;
            }
        }
        System.out.println(answer);
    }
}

