package com.company;

import javax.swing.text.html.HTML;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution s = new Solution();
        s.solution();
    }
}

class Solution {

    boolean[] visit;
    int min = 51;
    public void solution() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        visit = new boolean[words.length];
        dfs(begin, target, words, 0);
        if (min == 51) System.out.println(0);
        else System.out.println(min);

    }

    void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            min = Math.min(min, count);
        }
        for (int i = 0; i < words.length; i++) {
            if (!visit[i] && check(begin, words[i])) {
                visit[i] = true;
                dfs(words[i], target, words, count + 1);
                visit[i] = false;
            }
        }
    }

    boolean check(String before, String after) {
        int count = 0;
        for (int i = 0; i < after.length(); i++) {
            if (before.charAt(i) == after.charAt(i)) {
                count++;
            }
        }
        return count == before.length() - 1;
    }

}

