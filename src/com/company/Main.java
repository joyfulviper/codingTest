package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution s = new Solution();
        s.solution();
    }
}

class Solution {

    public void solution() {
        //마지막 인덱스부터 배송 가능한지, 픽업 가능한지 확인해 준다.
        //배송 가능하면 해당 단계에서 배송가 픽업이 모두 가능하다면 answer에 값을 더한 후 반복문을 이어간다.
        //배송 또는 픽업 중 한개만 된다면 answer에 값을 더한 후 반복문을 빠져나와 다음 인덱스를 확인한다.
        long answer = 0;
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        int delivery = 0;
        int pickup = 0;
        System.out.println(n - 1);
        for (int i = n - 1; i >= 0; i--) {
            delivery += deliveries[i];
            pickup += pickups[i];

            while (true) {
                if (delivery <= 0 && pickup <= 0) // 둘다 배송과 픽업이 완료
                    break;
                delivery -= cap;
                pickup -= cap;
                answer += (i + 1) * 2;
            }
        }
        System.out.println(answer);
    }
}

