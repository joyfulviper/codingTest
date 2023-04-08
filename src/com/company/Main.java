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
        //0부터 차례차례 더한다. 더한 값이 목표값보다 커질 경우 이전에 더한 값을 목표값보다 작아질 때 까지 하나씩 뺀다. 뺀 결과 목표값과 같으면 연속 증가 i 부터 j까지 연속증가 부분수열이다.
        //
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        int sum = 0;
        int j = 0;
        int answer[] = new int[2];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            while (sum > k) {
                sum -= sequence[j++];
            }

            if (sum == k) {
                if (min > Math.abs(i - j)) {
                    answer[0] = i;
                    answer[1] = j;
                    min = Math.abs(i - j);
                }
            }
        }
        System.out.println(answer[0] + "," + answer[1]);


    }
}

