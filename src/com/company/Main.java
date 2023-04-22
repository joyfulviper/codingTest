package com.company;

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

    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public void solution() {
        int n = 6;
        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1, 3};
        int[] summits = {5};
        int[] d = new int[n + 1];

        Arrays.fill(d, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            int c = path[2];
            //올라갔다 돌아오는 거리를 구하는게 아닌 정상까지 갔다가 내려오는 경로중 휴식 기간이 가장 짧은 기간을 구하는 거기 때문에
            //정상까지 가는 길중 가장 짧은 휴식기간이 포함된 길만 구하면 된다. 또한 정상은 여러번 들릴 수 없고 시작점도 여러번 들릴 수 없으므로
            //각각 출발, 도착시만 들릴 수 있도록 한다.
            if (isGate(a, gates) || isSummit(b, summits)) {
                graph.get(a).add(new Node(b, c));
            } else if (isGate(b, gates) || isSummit(a, summits)) {
                graph.get(b).add(new Node(a, c));
            } else {
                graph.get(a).add(new Node(b, c));
                graph.get(b).add(new Node(a, c));
            }
        }
        Queue<Node> q = new LinkedList<>();
        for (int gate : gates) {
            q.add(new Node(gate, 0));
            d[gate] = 0;
        }
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (d[now.x] < now.distance) continue;
            for (int i = 0; i < graph.get(now.x).size(); i++) {
                Node next = graph.get(now.x).get(i);
                int dist = Math.max(d[now.x], next.distance);
                if (dist < d[next.x]) {
                    d[next.x] = dist;
                    q.add(new Node(next.x, dist));
                }
            }
        }
        Arrays.sort(summits);
        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (int summit : summits) {
            if (d[summit] < min) {
                a = summit;
                b = d[summit];
            }
        }
        System.out.println(a + "," + b);
    }

    boolean isGate(int n , int[] gates) {
        for (int i : gates) {
            if (i == n) return true;
        }
        return false;
    }

    boolean isSummit(int n , int[] summits) {
        for (int i : summits) {
            if (i == n) return true;
        }
        return false;
    }
}

