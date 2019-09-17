package 校招2020.转转;

import 玩转算法面试.链表.num445_两数相加2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main1 {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public int levelOrder(Node root) {
        //请您完成此方法
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> list = new ArrayList();
            while (count > 0) {
                Node tmp = q.peek();
                q.poll();
                list.add(tmp.val);
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
                count--;
            }
            res.add(list);
        }
        Double ans = 0.0;
        int index = 0;
        for (int i = 0; i < res.size(); i++) {
            Double sum = 0.0;
            for (int j = 0; j < res.get(i).size(); j++) {
                sum += res.get(i).get(j);
            }
            Double avg = sum / res.get(i).size();
            if (avg > ans) {
                ans = avg;
                index = i + 1;
            }
        }
        return index;
    }
}
