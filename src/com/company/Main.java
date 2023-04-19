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
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int sum1 = 0;
        int sum2 = 0;

        for (int a : queue1) {
            q1.add(a);
            sum1 += a;
        }
        for (int a : queue2) {
            q2.add(a);
            sum2 += a;
        }
        int sum = sum1 + sum2;

        if (sum % 2 == 1) {
            System.out.println(sum);
        } else {

            sum /= 2;
            int p1 = 0;
            int p2 = 0;
            int limit = q1.size() * 2;
            while (p1 <= limit && p2 <= limit) {
                if (sum1 == sum) {
                    System.out.println(p1 + p2);
                    return;
                }
                if (sum1 > sum) {
                    sum1 -= q1.peek();
                    sum2 += q1.peek();
                    q2.add(q1.poll());
                    p1++;
                } else {
                    sum2 -= q2.peek();
                    sum1 += q2.peek();
                    q1.add(q2.poll());
                    p2++;
                }
            }
            System.out.println(-1);
        }
    }
}

