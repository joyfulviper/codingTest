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
    int[] rate = {10, 20, 30, 40};
    int[] emoticons = {1300, 1500, 1600, 4900};
    int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
    int[] answer = {0, 0};

    public void solution() {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        //int[] emoticons = {7000, 9000};

        dfs(0, emoticons.length, new int[emoticons.length]);
        System.out.println(answer[0] + "," + answer[1]);
    }

    void dfs(int depth, int emoLength, int[] input) {
        if (depth == emoLength) {
            int totalPay = 0;
            int plusNum = 0;
            for (int[] user : users) {
                int rate = user[0];
                int price = user[1];
                int pay = 0;
                for (int i = 0; i < input.length; i++) {
                    if (input[i] >= rate) {
                        pay += emoticons[i] * (100 - input[i]) / 100;
                    }
                }
                if (pay >= price) {
                    plusNum++;
                } else {
                    totalPay += pay;
                }
            }
            if (plusNum > answer[0]) {
                answer[0] = plusNum;
                answer[1] = totalPay;
            } else if (plusNum == answer[0] && totalPay > answer[1]) {
                answer[1] = totalPay;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            input[depth] = rate[i];
            dfs(depth + 1, emoLength, input);
        }
    }
}

