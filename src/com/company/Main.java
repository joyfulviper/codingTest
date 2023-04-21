package com.company;

import java.sql.Wrapper;
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
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int[][] dp = new int[n + 1][n + 1];
        int answer = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];
            dp[x][y] = 1;
            dp[y][x] = 1;
        }
        for (int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            dp[x][y] = 0;
            dp[y][x] = 0;
            answer = Math.min(answer, bfs(dp, i + 1, n));
            dp[x][y] = 1;
            dp[y][x] = 1;
        }
        System.out.println(answer);
    }
    int bfs(int[][] dp, int start, int n) {
        boolean[] check = new boolean[n + 1];
        check[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int cnt = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= n; i++) {
                if(check[i] == false && dp[now][i] == 1) {
                    q.add(i);
                    cnt++;
                    check[i] = true;
                }
            }
        }
        return Math.abs(n - (2 * cnt));
//n-cnt cnt
    }
}

