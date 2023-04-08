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
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        char[][] map = new char[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        Position start = null;
        int gx = 0;
        int gy = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'R') {
                    start = new Position(i, j, 0);
                } else if (map[i][j] == 'G') {
                    gx = i;
                    gy = j;
                }
            }
        }
        int[][] visit = new int[map.length][map[0].length];
        for (int i = 0; i < visit.length; i++)
            Arrays.fill(visit[i], Integer.MAX_VALUE);

        visit[start.x][start.y] = 0;

        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.add(start);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Position now = pq.poll();
            //System.out.println("현제 루트 좌표 "+now.x + "," + now.y);
            if (visit[now.x][now.y] < now.cost) continue;
            for (int i = 0; i < 4; i++) {
                int nx = now.x;
                int ny = now.y;
                if (i == 0) {
                    //System.out.println("왼쪽이동");
                    while (ny != 0) {
                        ny -= 1;
                        if (map[nx][ny] == 'D'){// 그줄 왼쪽 장애물
                            ny += 1;
                            break;
                        }

                    }
                } else if (i == 1) { //그줄 아래 장애물
                    //System.out.println("아래이동");
                    while (nx != map.length - 1) {
                        nx += 1;
                        if (map[nx][ny] == 'D') {
                            nx -= 1;
                            break;
                        }
                    }
                } else if (i == 2) { //그줄 오른쪽 장애물
                    //System.out.println("오른쪽이동");
                    while (ny != map[0].length - 1) {
                        ny += 1;
                        if (map[nx][ny] == 'D') {
                            ny -= 1;
                            break;
                        }
                    }
                } else {// 그줄 위쪽 장애물
                    //System.out.println("위쪽이동");
                    while (nx != 0) {
                        nx -= 1;
                        if (map[nx][ny] == 'D') {
                            nx += 1;
                            break;
                        }
                    }
                }
                //System.out.println(nx + "," + ny);
                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    int cost = visit[now.x][now.y] + 1;
                    if (cost < visit[nx][ny]) {
                        visit[nx][ny] = cost;
                        pq.add(new Position(nx, ny, cost));
                    }

                }
            }
            //System.out.println("------");
        }
        System.out.println(visit[gx][gy]);
    }
}

class Position implements Comparable<Position> {
    int x, y, cost;

    public Position(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Position p) {
        return Integer.compare(this.cost, p.cost);
    }
}

