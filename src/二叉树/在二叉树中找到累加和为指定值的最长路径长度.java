package 二叉树;
/*
 在二叉树中找到累加和为指定值的最长路径长度
 */

import java.util.HashMap;

public class 在二叉树中找到累加和为指定值的最长路径长度 {

    public int getMaxLength(Node head, int sum) {   //sun为指定的值
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0);  //重要
        return preOrder(head, sum, 0, 1, 0, sumMap);
    }

    /*
    head:树节点
    sum:指定的值
    preSum:遍历上一个节点累加的值
    level: 当前节点所在的level
    maxLen：遍历到当前节点求得的最长路径
    sumMap:<k:遍历到当前节点累加的和，v:当前节点所在的level>
     */
    public int preOrder(Node head, int sum, int preSum, int level,
                        int maxLen, HashMap<Integer, Integer> sumMap) {
        if (head == null) {
            return maxLen;
        }
        int curSum = preSum + head.value;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        if (sumMap.containsKey(curSum - sum)) {
            maxLen = Math.max(level - sumMap.get(curSum), maxLen);
        }
        maxLen = preOrder(head.left, sum, curSum, level++, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, curSum, level++, maxLen, sumMap);

        if (level == sumMap.get(curSum)) {   //说明curSum这个累加和是在遍历到cur时加上去的
            sumMap.remove(curSum);
        }
        return maxLen;
    }
}
