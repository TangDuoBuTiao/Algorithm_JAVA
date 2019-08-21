package 二叉树;
/*
 把一个搜索二叉树后序遍历的结果数组，还原为搜索二叉树
 */



public class 根据后续数组重建搜索二叉树 {

    public Node posArrayToSBT(int[] arr) {
        if (arr == null) {
            return null;
        }
        return buileTree(arr, 0, arr.length - 1);
    }

    private Node buileTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        Node head = new Node(arr[end]);
        int less = -1;
        int more = end;

        for (int i = start; i < end; i++) {        //循环arr[start, end)
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        head.left = buileTree(arr, start, less);             // arr[start, less]
        head.right = buileTree(arr, more, end - 1);      //arr[more, end-1]
        return head;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 6, 5, 7, 4};
        根据后续数组重建搜索二叉树 f = new 根据后续数组重建搜索二叉树();
        按层打印二叉树 p = new 按层打印二叉树();
        p.printTreeByLevel(f.posArrayToSBT(a));   //把构建好的搜索二叉树按层次打印出来
    }
}
