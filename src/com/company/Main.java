package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        s.solution();
    }
}

class Position {
    long x, y;

    public Position(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    public void solution() {
        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};//{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        long minx= Long.MAX_VALUE, miny= Long.MAX_VALUE;
        long maxx= Long.MIN_VALUE, maxy= Long.MIN_VALUE;
        HashSet<Position> pSet= new HashSet<>();
        for (int i = 0; i < line.length; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                int c = line[j][0];
                int d = line[j][1];
                int f = line[j][2];
                long adbc= a*d-b*c;
                if(adbc==0) continue; //비교대상 직선과 평행함

                long bfed= b*f-e*d;
                if(bfed%adbc!=0) continue; //x가 정수가 아님

                long ecaf= e*c-a*f;
                if(ecaf%adbc!=0) continue; //y가 정수가 아님

                long x= bfed/adbc;
                long y= ecaf/adbc;

                pSet.add(new Position(x, y));
                minx= Math.min(minx, x);
                miny= Math.min(miny, y);
                maxx= Math.max(maxx, x);
                maxy= Math.max(maxy, y);
            }
        }

        boolean[][] answerTemp = new boolean[(int) (maxy- miny +1)][(int) (maxx - minx + 1)];
        String[]answer = new String[answerTemp.length];
        for (Position p : pSet) {
            int x = (int) (p.x - minx);
            int y = (int) (p.y - maxy);

            answerTemp[Math.abs(y)][Math.abs(x)] = true;
        }
        int i = 0;
        for (boolean[] bs : answerTemp) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : bs) {
                if(b) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            answer[i++] = sb.toString();
        }
        for (String s : answer)
            System.out.println(s);
    }
}

