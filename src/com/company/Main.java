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
        int[] arrayA = {10, 17};
        int[] arrayB = {5, 20};

        int a = findGCD(arrayA);
        List<Integer> divisors = findDivisors(a);
        divisors.sort((o1, o2) -> Integer.compare(o2, o1));
        int b = findGCD(arrayB);
        List<Integer> divisors2 = findDivisors(b);
        divisors2.sort((o1, o2) -> Integer.compare(o2, o1));

        int result1 = Integer.MIN_VALUE;
        int result2 = Integer.MIN_VALUE;

        for (int i = 0; i < divisors.size(); i++) {
            int count = 0;
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayB[j] % divisors.get(i) != 0) {
                    count++;
                }
            }
            if (count == arrayB.length) {
                result1 = divisors.get(i);
                break;
            }
        }

        for (int i = 0; i < divisors2.size(); i++) {
            int count = 0;
            for (int j = 0; j < arrayA.length; j++) {
                if (arrayA[j] % divisors2.get(i) != 0) {
                    count++;
                }
            }
            if (count == arrayB.length) {
                result2 = divisors2.get(i);
                break;
            }
        }
        int answer = Math.max(result1, result2);
        if (answer < 0)
            answer = 0;
        System.out.println(answer);

    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 배열 원소들의 최대 공약수를 찾는 함수
    public static int findGCD(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = gcd(result, numbers[i]);
        }
        return result;
    }

    public static List<Integer> findDivisors(int a) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }
}

