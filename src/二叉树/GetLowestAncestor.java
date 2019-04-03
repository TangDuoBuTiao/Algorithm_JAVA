package 二叉树;
/*
 原问题：找到两个节点o1和o2最近的公共祖先节点
   以后序遍历的方式遍历，假设当前遍历的节点为cur,因为是后序遍历，假设处理cur左子树时返回的是left,处理右子树时返回的是right
   1.如果cur = null 或者 cur = o1 或者 cur = o2 ,直接返回cur
   2.如果left和right都为空，说明整个以cur为根节点的树上没有发现o1和o2，返回null
   3.如果left和right都不为空，说明left有o1或o2，right中有o1或o2,说明首次在cur相遇，返回cur
   4.如果left和right有一个为空，另一个不为空，此时有两种情况：a.不为空的节点是o1或o2中的一个   b.不为空的节点已经是公共祖先节点
 */

import java.util.HashMap;
import java.util.HashSet;

public class GetLowestAncestor {

    //原问题递归解法
    public Node getLowestAncestor1(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = getLowestAncestor1(head.left, o1, o2);
        Node right = getLowestAncestor1(head.right, o1, o2);
        if (left != null && right != null) {   //即使找到了答案，也得继续遍历下去
            return head;
        }
        return left != null ? left : right;
    }

    /*
    进阶问题：如果查询两个节点的公共祖先节点很频繁，想法让单条查询的查询时间减少
    解法：建立一个哈希表，存每个节点的父节点，根据这个哈希表找到o1节点到根节点路径上所有的节点，把这些节点存在HashSet
         再根据哈希表找o2的父节点，如果o2的父节点出现在HashSet，表明是公共祖先节点
     */

    public class Record1 {
        private HashMap<Node, Node> map;

        public Record1(Node head) {
            map = new HashMap<>();
            if (head !=null){
                map.put(head, null);
            }
            setMap(head);
        }

        private void setMap(Node head) {   //递归建立哈希表
            if (head == null) {
                return;
            }
            if (head.left != null) {
                map.put(head.left, head);
            }
            if (head.right != null) {
                map.put(head.right, head);
            }
            setMap(head.left);
            setMap(head.right);
        }

        public Node query(Node head, Node o1, Node o2) {
            HashSet<Node> path = new HashSet<>();
            while (map.containsKey(o1)) {
                path.add(o1);         //找到包含o1在内的所有父节点
                o1 = map.get(o1);
            }
            while (!path.contains(o2)) { //判断o2的父节点是不是和o1的父节点重叠
                o2 = map.get(o2);
            }
            return o2;
        }


    }

}
