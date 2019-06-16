package 剑指offer;
/*
 * 解法：使用双端队列Deque, 如果是从左向右打印，就头出尾进（先把根节点加进队头）
 *      如果是从右向左打印，就头进尾出。
 */
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
public class 按之字形打印二叉树 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int x){
            this.val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        boolean lr = true;   // true: 从左到右   false:从右到左
        TreeNode last = pRoot;
        TreeNode nLast = null;
        Deque<TreeNode> dq = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dq.offerFirst(pRoot);
        while(!dq.isEmpty()){
            if(lr){   //从左到右打印   头出尾进
                pRoot = dq.pollFirst();
                if(pRoot.left != null){
                    nLast = nLast == null ? pRoot.left : nLast;
                    dq.offerLast(pRoot.left);
                }
                if(pRoot.right != null){
                    nLast = nLast == null ? pRoot.right : nLast;
                    dq.offerLast(pRoot.right);
                }
            }else{   //从右到左打印   头进尾出
                pRoot = dq.pollLast();
                if(pRoot.right != null){
                    nLast = nLast == null ? pRoot.right : nLast;
                    dq.offerFirst(pRoot.right);
                }
                if(pRoot.left != null){
                    nLast = nLast == null ? pRoot.left : nLast;
                    dq.offerFirst(pRoot.left);
                }
            }
            list.add(pRoot.val);
            if(pRoot == last && !dq.isEmpty()){
                lr = !lr;
                last = nLast;
                nLast = null;
                res.add(new ArrayList(list));
                list.clear();
            }
        }
        res.add(new ArrayList(list));
        return res;
    }
}
