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
        int storey = 1952;
        int sum = 0;

        while (storey > 0) {
            int oneDigit = storey % 10;
            int tenDigit = (storey / 10) % 10;

            if (oneDigit > 5) {
                sum += 10 - oneDigit;
                storey += 10;
            } else if (oneDigit == 5) {
                sum += 5;
                if (tenDigit >= 5) {
                    storey += 10;
                }
            } else {
                sum += oneDigit;
            }
            storey /= 10;
        }
        System.out.println(sum);
    }



}

