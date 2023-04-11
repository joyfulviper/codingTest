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

    int min = Integer.MAX_VALUE;

    public void solution() {
        //picks를 앞에서부터 그냥 쭉 탐색picks 하나당 5개의 광물을 캘 수 있음 따라서 한번의 깊이마다 5번의 계산을 함
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        for (int i = 0; i < 3; i++) {
            if (picks[i] != 0) {
                int[] cPicks = picks.clone();
                cPicks[i] -= 1;
                dfs(cPicks, minerals, i, 0, 0);
            }
        }
        System.out.println(min);
    }

    void dfs(int[] picks, String[] minerals, int pickLocation, int location, int sum) {
        int i = 0;
        for (; i < 5; i++) {//앞에 5개 먼저 캐기
            if (location + i >= minerals.length) {
                break;
            }
            if (pickLocation == 0) {
                sum += 1;
            } else if (pickLocation == 1) {
                if (minerals[location + i].equals("diamond")) {
                    sum += 5;
                } else {
                    sum += 1;
                }
            } else {
                if (minerals[location + i].equals("diamond")) {
                    sum += 25;
                } else if (minerals[location + i].equals("iron")) {
                    sum += 5;
                } else {
                    sum += 1;
                }
            }
        }
        location += i;
        if (location >= minerals.length) {
            min = Math.min(sum, min);
            return;
        }
        if (sum >= min) {
            return;
        }

        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            min = Math.min(sum, min);
            return;
        }


        for (i = 0; i < 3; i++) {
            if (picks[i] != 0) {
                int[] cPicks = picks.clone();
                cPicks[i] -= 1;
                dfs(cPicks, minerals, i, location, sum);
            }
        }
    }
}

