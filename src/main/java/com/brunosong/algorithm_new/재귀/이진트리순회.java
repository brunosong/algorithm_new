package com.brunosong.algorithm_new.재귀;

import com.brunosong.algorithm_new.객체.Node;
import org.springframework.cglib.proxy.NoOp;

import java.util.LinkedList;
import java.util.Queue;

public class 이진트리순회 {

    /*

        이진트리 순회(깊이우선탐색)
        아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.

        전위순회 출력 : 1 2 4 5 3 6 7
        중위순회 출력 : 4 2 5 1 6 3 7
        후위순회 출력 : 4 5 2 6 7 3 1

    */

    public static void main(String[] args) {

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);

        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);


        DFS(root);

        BFS(root);

    }
    /* 깊이우선탐색 */
    static void DFS(Node root) {

        if(root == null) return;
        else {
            //System.out.println(root.num);  //전위
            DFS(root.lt);
            //System.out.println(root.num);  //중위
            DFS(root.rt);
            System.out.println(root.num);  //후위
        }


    }

    /* 넓이우선탐색 : 레벨탐색 */
    static void BFS(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int lv = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            System.out.println("=========== lv ========= : " + lv);

            for (int i = 0; i < size; i++) {

                Node poll = queue.poll();
                System.out.print(poll.num + " ");
                if(poll.lt != null) queue.offer(poll.lt);
                if(poll.rt != null) queue.offer(poll.rt);
            }

            lv++;
            System.out.println(" ");
        }

    }






}
