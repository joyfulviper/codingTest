package com.company;

import java.awt.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        s.solution();
    }
}

class Node {
    int x, distance;
    public Node(int x, int distance) {
        this.x = x;
        this.distance = distance;
    }
}
class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int[] d;
    int n;
    public void solution() {
        int n = 3;
        int[][] roads = {{1, 2}, {2, 3}};
        int[] sources = {2, 3};
        int destination = 1;
        this.n = n;
        d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        dijkstra(destination);
        for (int source : sources) {
            System.out.println(d[source]);
        }
    }

    void dijkstra(int start) {
        d[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (d[next] > d[now] + 1) {
                    d[next] = d[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}

