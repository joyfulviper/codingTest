package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        s.solution();
    }
}


class Node {
    Node prev;
    Node next;
    boolean isDelete;
}
class Solution {

    public void solution() {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};//{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        Node[] nodes = new Node[1000001];
        nodes[0] = new Node();
        for (int i = 1; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].prev = nodes[i - 1];
            nodes[i - 1].next = nodes[i];
        }
        Node now = nodes[k];
        Stack<Node> delete = new Stack<>();
        for (String query : cmd) {
            char command = query.charAt(0);
            if (command == 'U') {
                int cnt = Integer.parseInt(query.substring(2));
                for (int i = 0; i < cnt; i++) {
                    now = now.prev;
                }
            } else if (command == 'D') {
                int cnt = Integer.parseInt(query.substring(2));
                for (int i = 0; i < cnt; i++) {
                    now = now.next;
                }
            } else if (command == 'C') {
                now.isDelete = true;
                Node next = now.next;
                Node prev = now.prev;
                delete.push(now);
                if (prev != null) {
                    prev.next = next;
                } if (next != null) {
                    next.prev = prev;
                    now = next;
                } else {
                    now = prev;
                }
            } else {
                Node node = delete.pop();
                node.isDelete = false;
                Node next= node.next;
                Node prev = node.prev;
                if (next != null) {
                    next.prev = node;
                } if (prev != null) {
                    prev.next = node;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodes[i].isDelete == true) sb.append("X");
            else sb.append("O");
        }
        System.out.println(sb.toString());
    }
}

