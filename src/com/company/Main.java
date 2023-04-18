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
        int[] topping = {1, 1, 1, 1, 1, 1};
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int top : topping) {
            map.put(top, map.getOrDefault(top, 0) + 1);
        }
        int answer = 0;
        for (int top :topping) {
            set.add(top);
            map.put(top, map.get(top) - 1);
            if (map.get(top) == 0) {
                map.remove(top);
            }
            if (map.size() == set.size()) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    int count(char[] input) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }
        return set.size();
    }
}

