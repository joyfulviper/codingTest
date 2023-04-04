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
        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        //내 앞의 사람은 나보다 근무태도가 좋다. 내 앞의 사람이 만약 나보다 동료평가 점수까지 높다면 나는 탈락이다.
        int[] wh = scores[0];
        Arrays.sort(scores, (o1, o2) -> {
           if (o1[0] == o2[0]) {
               return Integer.compare(o1[1], o2[1]);
           }
           return Integer.compare(o2[0], o1[0]);
        });

        int answer = 1;
        int maxScore = 0;//내 앞사람의 동료 평가 점수
        for (int[] score : scores) {
            if (maxScore > score[1]) {// 내 앞사람 중 나보다 동료 평가 점수가 높은 사람이 있다면 나는 인센티브 탈락자
                if (score.equals(wh)) {
                    answer = -1;
                    break;
                }
            } else {
                maxScore = Math.max(score[1], maxScore);
                if (score[0] + score[1] > wh[0] + wh[1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }
}

