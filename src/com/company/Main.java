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
    int max = -1;
    List<int[]> list = new ArrayList<>();
    public void solution() {
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        dfs(0, 0, new int[11], n, info);
        list.sort(((o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return Integer.compare(o2[i], o1[i]);
            }
            return 0;
        }));
        int[] answer = list.get(0);

    }

    void dfs(int depth, int start, int[] result, int n, int[] info) {
        if (depth == n) {
            int a_sum = 0;
            int r_sum = 0;
            for (int i = 0; i < result.length; i++) {
                if (result[i] == 0 && info[i] == 0) continue;
                if (result[i] > info[i]) r_sum += 10 - i;
                else a_sum += 10 - i;
            }
            if (r_sum > a_sum) {
                int gap = r_sum - a_sum;
                if (max < gap) {
                    max = gap;
                    list.clear();
                    list.add(result.clone());
                } else if (gap == max) {
                    list.add(result.clone());
                }
            }
            return;
        }
        for (int i = start; i < 11; i++) {
            result[i]++;
            dfs(depth + 1, i, result, n, info);
            result[i]--;
        }
    }
}

