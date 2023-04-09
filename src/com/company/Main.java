package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        s.solution();
    }
}

class Subject {
    String name;
    String startTime;
    int taskTime;
    int totalTime;

    public Subject(String name, String startTime, int taskTime) {
        this.name = name;
        this.startTime = startTime;
        this.taskTime = taskTime;
        String[] s = startTime.split(":");
        this.totalTime = Integer.valueOf(s[0]) * 60 + Integer.valueOf(s[1]);
    }

    public void task() {
        this.taskTime -= 1;
    }
}

class Solution {

    public void solution() {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        Arrays.sort(plans, (o1, o2) -> {
            String[] time = o1[1].split(":");
            String[] time2 = o2[1].split(":");
            int hour = Integer.valueOf(time[0]);
            int min = Integer.valueOf(time[1]);

            int hour2 = Integer.valueOf(time2[0]);
            int min2 = Integer.valueOf(time2[1]);

            if (hour == hour2) {
                return Integer.compare(min, min2);
            }
            return Integer.compare(hour, hour2);
        });

        int sum = 0;
        int time = 0;
        ArrayList<Subject> subjects = new ArrayList<>();
        Stack<Subject> remainTask = new Stack<>();
        List<Subject> answerList = new ArrayList<>();
        for (String[] s : plans) {
            //System.out.print(s[0] + " ");
            subjects.add(new Subject(s[0], s[1], Integer.valueOf(s[2])));
            sum += Integer.valueOf(s[2]);
        }/*
               1.현재 시간과 과제 시작시간을 더했을 때 다음 과제의 시간보다 작다면 answerList에 더한다.
               2.그렇지 않다면 stack에 push 하고 다음 과제를 수행한다.

               1번의 과정이후 다음 과제가 없으면서 스택이 비어있지 않을 경우 스택에서 과제를 꺼내서 수행한다.
                스택에서 꺼낸 과제랑 다음 과제랑 비교해서 시간 안에 수행 가능하면 pop 수행 불가능하면 수행한 시간만큼 뺀다음에 push
                현재 시간을 어떻게 초기화 하느냐.
        */
        for (int i = 0; i < subjects.size() - 1; i++) {// size가 3짜리면
            Subject now = subjects.get(i);
            int cur = now.totalTime;
            Subject next = subjects.get(i + 1);
            if (cur + now.taskTime <= next.totalTime) {
                answerList.add(now);
                cur += now.taskTime;
                while (!remainTask.isEmpty()) {
                    now = remainTask.pop();
                    if (cur + now.taskTime <= next.totalTime) {
                        answerList.add(now);
                        cur += now.taskTime;
                    } else {
                        now.taskTime -= next.totalTime - cur;
                        remainTask.push(now);
                        break;
                    }
                }
                if (i + 1 == subjects.size() - 1) {
                    answerList.add(next);
                }
            } else {
                //System.out.println(i);
                if (i + 1 == subjects.size() - 1) {
                    answerList.add(next);
                }
                now.taskTime -= next.totalTime - cur;
                remainTask.push(now);
            }
        }
        while (!remainTask.isEmpty()) {
            answerList.add(remainTask.pop());
        }
        for (Subject s : answerList) {
            System.out.println(s.name);
        }
    }
}

