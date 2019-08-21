package 二叉树;
/*
公司的等级多叉树结构，每个节点都有自己的快乐值，直接上级来了，下级就不能来
 */

import java.util.List;

public class 派对的最大快乐 {
    class Employee {
        public int happy;  //这名员工可以带来的欢乐值
        List<Employee> subordinates;  //这名员工有哪些直接下级

    }

    //建立信息类
    public class ReturnType {
        public int yesHeadMax;
        public int noHeadMax;

        public ReturnType(int yes, int no) {
            this.yesHeadMax = yes;
            this.noHeadMax = no;
        }
    }

    //设计递归函数
    public ReturnType process(Employee X) {
        int yesX = X.happy;  //X来的情况下，一定要加上自己的欢乐值
        int noX = 0;         //X没来的情况下，不加自己的欢乐值
        if (X.subordinates.isEmpty()) {         //如果X是底层员工，没有直接下级，直接返回自己的信息
            return new ReturnType(yesX, noX);
        } else {
            for (Employee next : X.subordinates) {  //枚举X的每一个员工next
                ReturnType subTreeInfo = process(next);
                yesX += subTreeInfo.noHeadMax;
                noX += Math.max(subTreeInfo.yesHeadMax, subTreeInfo.noHeadMax);
            }
            return new ReturnType(yesX, noX);
        }
    }

    public int getMaxHappy(Employee boss) {
        ReturnType allTreeInfo = process(boss);
        return Math.max(allTreeInfo.yesHeadMax, allTreeInfo.noHeadMax);
    }
}
