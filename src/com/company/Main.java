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
        String today = "2020.01.01";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.valueOf(s[1]));
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] s = privacy.split(" ");
            int period = map.get(s[1]);
            String[] s2 = s[0].split("\\.");
            int year = Integer.valueOf(s2[0]);
            int month = Integer.valueOf(s2[1]);
            int day = Integer.valueOf(s2[2]);

            year += period / 12;
            month += period % 12;
            if (month > 12) {
                year += 1;
                month = month - 12;
            }
            day -= 1;
            if (day == 0) {
                day = 28;
                month--;
                if (month == 0) {
                    month = 12;
                    year--;
                }
            }

            String[] s3 = today.split("\\.");
            int todayYear = Integer.valueOf(s3[0]);
            int todayMonth = Integer.valueOf(s3[1]);
            int todayDay = Integer.valueOf(s3[2]);
            System.out.println(year + "." + month + "." + day);
            if (todayYear > year) {
                list.add(i + 1);
            } else if (todayYear == year) {
                if (todayMonth > month) {
                    list.add(i + 1);
                } else if (todayMonth == month) {
                    if (todayDay > day) {
                        list.add(i + 1);
                    }
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length;i++) {
            answer[i] = list.get(i);
        }
    }
}

