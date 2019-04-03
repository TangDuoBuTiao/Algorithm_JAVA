package 二叉树;
/*
使用一个有序的数组sortArr生成一个平衡搜索二叉树，并且这个平衡搜索二叉树的中序遍历结果和sortArr保持一致
解法：使用递归的方式，先找到中间的数当根节点，左右两边的子数组继续使用这种方法，直到 (start > end)
 */

import 二叉树.Node;
import 二叉树.PrintTreeByLevel;

public class SortArrToBalancedSBT {
    public Node sortArrToBSBT(int[] sortArr) {
        if (sortArr == null) {
            return null;
        }
        return generate(sortArr, 0, sortArr.length - 1);
    }

    public Node generate(int[] sortArr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;    //向下取整，保证得到的搜索树的后序遍历还是sortArr
        Node head = new Node(sortArr[mid]);
        head.left = generate(sortArr, start, mid - 1);
        head.right = generate(sortArr, mid + 1, end);
        return head;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        SortArrToBalancedSBT f = new SortArrToBalancedSBT();
        Node ans = f.sortArrToBSBT(a);

        PrintTreeByLevel p = new PrintTreeByLevel();
        p.printTreeByLevel(ans);
    }

}
