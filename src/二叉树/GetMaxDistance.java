package 二叉树;
/*
 问题：找到二叉树中最大距离
 解法：使用dp套路：依次求出每个节点为头结点的子树的最大距离，那么最终答案一定在其中。
        第一步：以某个节点X为头结点的子树中，分析答案来自哪些可能性。
              ①可能性一：以X为头结点，最大距离可能在X的左子树中
              ②可能性二：以X为头结点，最大距离可能在X的右子树中
              ③可能性三：以X为头结点，最大距离可能在从X的左子树离X最远的点，先到达X，然后走到X的右子树最远的点
                        此时的最大距离 = 左子树的高度 + 右子树的高度 + 1
        第二步：根据第一步的所有可能性，列出所有需要的信息，（左右子树都需要知道自己这棵树的最大距离，以及高度这两个信息）
        第三步：根据第二步汇总的信息，建立ReturnType类
        第四步：设计递归函数（1.递归的返回条件；2.默认直接得到左右子树的信；3.把所有可能性做整合；4.返回第三步的信息结构）
 */

public class GetMaxDistance {

    //建立递归函数返回的类型
    public class ReturnType {
        public int height;
        public int maxDist;

        public ReturnType(int height, int maxDist) {
            this.height = height;
            this.maxDist = maxDist;
        }
    }

    //递归函数(后序遍历)
    public ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int maxDist = Math.max(leftData.height + rightData.height + 1,
                Math.max(leftData.maxDist, rightData.maxDist));

        return new ReturnType(height, maxDist);
    }

    public int getMaxDistance(Node head) {
        return process(head).maxDist;
    }

}
