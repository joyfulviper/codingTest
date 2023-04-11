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
        int n = 10;
        int m = 10;
        int startX = 3;
        int startY = 7;
        int[][] balls = {{7, 7}, {2, 7}, {7, 3}};

        int answer[] = new int[balls.length];
        int i = 0;
        for(int[] ball : balls) {
            int x = ball[0];
            int y = ball[1];

            if (x == startX) {
                if (x < m - x ) {
                    x = 2 * x;
                } else {
                    x = 2 * (m - x);
                }
                answer[i++] = (int) Math.pow(y - startY, 2) + (int) Math.pow(x, 2);
            } else if (y == startY) {
                if (y < n - y) {
                    y = 2 * y;
                } else {
                    y = 2 * (n - y);
                }
                answer[i++] = (int) Math.pow(x - startX, 2) + (int) Math.pow(y, 2);
            } else {
                int a = (int) Math.pow(x + startX, 2) + (int) Math.pow(y - startY, 2);
                int b = (int) Math.pow(m - x + m - startX, 2) + (int) Math.pow(y - startY, 2);
                int c = (int) Math.pow(x - startX, 2) + (int) Math.pow(y + startY, 2);
                int d = (int) Math.pow(x - startX, 2) + (int) Math.pow(n - y + n - startY, 2);
                answer[i++] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }
        for (int a : answer)
            System.out.println(a);
    }
}

