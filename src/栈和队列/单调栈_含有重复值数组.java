package 栈和队列;
/*
 给定一个可以有重复值的数组，找到每一个i位置左边和右边离i最近且值比arr[i]小的位置。返回所有位置相应的信息。

 解法：使用单调栈结构，令stack从栈顶到栈底严格递增，stack里存的元素类型是List<Integer>
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 单调栈_含有重复值数组 {

    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop();
                // 取位于下面位置的列表中，最晚加入的那个（List的最后一个元素）
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popi : popIs) {
                    res[popi][0] = leftLessIndex;
                    res[popi][1] = i;
                }
            }
            //新元素比栈顶元素大，直接进栈,但进栈前有说法，判断一个是否和当前栈顶元素相等
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>(); //如果不重复，创建新的List保存当前位置
                list.add(i);
                stack.push(list);
            }
        }
        //数组遍历完后，出栈。特点：右边都没有比自己小的元素，恒为-1。
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            //取位于下面位置的列表中，最晚加入的那个
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popi : popIs) {
                res[popi][0] = leftLessIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 3, 4, 3, 5, 3, 2, 2};
        //打印结果二维数组
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(getNearLess(a)[i]));
        }

    }
}