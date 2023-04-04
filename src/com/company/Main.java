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
        Scanner sc = new Scanner(System.in);

        int[] weights = {100, 180, 360, 100, 270};
        Arrays.sort(weights);
        long count = 0;
        //1:1 1:2 2:3 3:4
        Map<Double, Integer> map = new HashMap<>();
        for (int weight : weights) {
            double d1 = weight * 1.0;
            double d2 = weight / 2.0;
            double d3 = (weight / 3.0) * 2.0;
            double d4 = (weight / 4.0) * 3.0;
            if (map.containsKey(d1)) count += map.get(d1);
            if (map.containsKey(d2)) count += map.get(d2);
            if (map.containsKey(d3)) count += map.get(d3);
            if (map.containsKey(d4)) count += map.get(d4);
            map.put(d1, map.getOrDefault(d1, 0) + 1);
        }
        System.out.println(count);
    }
}

