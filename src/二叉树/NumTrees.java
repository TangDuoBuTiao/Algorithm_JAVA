package 二叉树;
/*
给定一个数字N，把它看成中序遍历的结果{1,2,3...,N}，返回的二叉树结构有多少种
Eg: N = -1 代表空树结构，返回1； N = 2时，代表中序遍历是{1,2}，可能的二叉树结构有两种
解法：中序遍历有序且无重复，则二叉树必为搜索二叉树，假设num(a)代表a个节点的搜索二叉树有多少种可能
      假设序列为{1,...,i,...N}
      ① 如果以1作为头结点，1不可能有左子树，故以1作为头结点的可能性结构完全取决于1的右子树有多少种结构，
        1的右子树有N-1个节点，所有有num(N-1)种可能。
      ② 如果以i作为头结点，i的左子树有i-1个节点，所以可能的结构有num(i-1)种，右子树有N-i个节点，
        所以有num(N-i)种可能，故以i为头结点的可能结构有num(i-1) x num(N-i)
      ③ 如果以N为头结点，N不可能有右子树，N地方左子树有(N-1)个节点，所有有num(N-1)种。
      把1~N分布作为头结点，把所有可能性的结构加起来就是答案。
 */

public class NumTrees {
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

    public static void main(String[] args) {
        NumTrees n = new NumTrees();
        System.out.print(n.numTrees(2));
    }
}
