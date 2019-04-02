package 二叉树;
/*
 判断一课二叉树是否是一棵平衡二叉树
 解答：依次考察每个节点为头结点的子树，如果都是平衡二叉树，那么整体就是一个平衡二叉树

 可能性一：X的左子树不是平衡的，则以X为头结点的树就不是平衡的
 可能性二：X的右子树不是平衡的，则以X为头结点的树就不是平衡的
 可能性三：X的左右子树高度相差1，则以X为头结点树就不平衡的
 可能性四：以上可能性都没有中，那么以X为头结点的树就是平衡的
 */

public class IsBalanced {
    //树节点
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //定义一个类
    public class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    //递归函数
    public ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(head.left);  //先遍历X节点左，再右，再回退到X节点，（后序遍历）
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1; //左右子树的最大高度加上当前节点，就是当前节点的高度
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);  //返回 回退到某个以X为根节点的信息
    }

    public boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }
}
