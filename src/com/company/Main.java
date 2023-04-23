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
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer= new int[5];
        int index = 0;
        for (String[] place : places) {
            boolean check = true;
            for (int i = 0; i < place.length; i++) {
                for (int j = 0; j < place[i].length(); j++) {
                    if (place[i].charAt(j) == 'P') {
                        if (isPlus(i, j, place) || isPlus2(i, j, place) || isX(i, j, place)) {
                            check = false;
                            break;
                        }
                    }
                }
                if (!check) {
                    break;
                }
            }
            if (check) {
                answer[index++] = 1;
            } else {
                answer[index++] = 0;
            }
        }
        for(int a : answer)
            System.out.println(a);
    }
    boolean isPlus(int x, int y, String[] place) {
        //System.out.println("현재좌표:" + x + "," + y);
        int[] dx = {1, 0 ,-1, 0};
        int[] dy = {0, 1, 0, -1};
        char[][] map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if (map[nx][ny] == 'P') {
                    return true;
                }
            }
        }
        //System.out.println("+ 통과");
        return false;
    }

    boolean isPlus2(int x, int y, String[] place) {
        //System.out.println("현재좌표2:" + x + "," + y);
        int[] dx = {2, 0 ,-2, 0};
        int[] dy = {0, 2, 0, -2};
        int[] dx2 = {1, 0, -1, 0};
        int[] dy2 = {0, 1, 0, -1};
        char[][] map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int mx = x + dx2[i];
            int my = y + dy2[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if (map[nx][ny] == 'P' && map[mx][my] == 'O') {
                    return true;
                }
            }
        }
        //System.out.println("+2 통과");
        return false;
    }

    boolean isX(int x, int y, String[] place) {
        //System.out.println("현재좌표3:" + x + "," + y);
        int[] dx = {-1, 1, 1, -1};
        int[] dy = {1, 1, -1, -1};
        //오른쪽 위, 오른쪽 아래, 왼쪽 아래, 왼쪽 위
        int[] dx2 = {-1, 1, 1, -1};
        int[] dy2 = {1, 1, -1, -1};
        char[][] map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int mx = x + dx2[i];
            int my = y + dy2[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if (map[nx][ny] == 'P') {
                    if (map[x][my] == 'O' || map[mx][y] == 'O')
                        return true;
                }
            }
        }
        //System.out.println("X 통과");
        return false;
    }

}

