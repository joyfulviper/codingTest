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
        int n = 7;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        int k = 3;
        int sum = 0;
        //List<Integer> pre = new LinkedList<>();

        PriorityQueue<Integer> pre = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        for (int e : enemy) {
            sum += e;
            pre.add(e);
            if (sum > n) {
                if (k > 0) {
                    k--;
                    int subtract = pre.poll();
                    sum -= subtract;
                } else {
                    break;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}

