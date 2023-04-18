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
        int k = 5;
        int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};

        List<Double> values = new ArrayList<>();

        while (true) {
            values.add((double) k);
            if (k == 1)
                break;
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
        }
        List<Double> widths = new ArrayList<>();
        for (int i = 1; i < values.size(); i++) {
            double width = (values.get(i) + values.get(i - 1)) / 2;
            widths.add(width);
            //System.out.println(widths.get(i - 1));
        }
        List<Double> answerList = new ArrayList<>();
        System.out.println();
        for (int[] range : ranges) {
            int left = range[0];
            int right = range[1];
            right += widths.size();

            System.out.println("right:" + right);
            double result = 0;
            if (left == right) {
                result = 0;

            } else if (left > right) {
                result = -1.0;
            } else {
                for (int i = left; i < right; i++) {
                    result += widths.get(i);
                }
            }
            answerList.add(result);
        }
        double[] answer = new double[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
            //System.out.println(answer[i]);
        }

    }
}

