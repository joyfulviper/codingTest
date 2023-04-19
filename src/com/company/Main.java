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
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        int start = 0;
        int count = 0;
        while (true) {
            Map<String, Integer> map2 = new HashMap<>();
            boolean check = false;
            for (int i = start; i < start + 10; i++) {
                map2.put(discount[i], map2.getOrDefault(discount[i], 0) + 1);
            }
            for (String s : map.keySet()) {
                if (map.get(s) != map2.get(s)) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                count++;
            }
            start++;
            if (start + 10 > discount.length) {
                break;
            }
        }
        System.out.println(count);
    }
}

