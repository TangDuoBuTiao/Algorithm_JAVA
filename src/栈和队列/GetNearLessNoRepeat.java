package 栈和队列;

/*
 给定一个不含有重复值的数组，找到每一个i位置左边和右边离i最近且值比arr[i]小的位置。返回所有位置相应的信息。

 解法：使用单调栈结构，令stack从栈顶到栈底严格递增
 */
import java.util.Stack;

public class GetNearLessNoRepeat {
    public static int[][] getNearLessNoRepeat(int arr[]) {
        int[][] res = new int[arr.length][2];    //定义输出结构 => 二维数组
        Stack<Integer> stack = new Stack<>();    //定义单调栈，存放数组下标
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {   //新元素比栈顶元素大 -> 不进while,直接进栈
                int popIndex = stack.pop();  //把栈顶元素弹出来后，再peek()得到的就是原栈顶元素左边最近且less的位置（下标）。
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();  //如果栈为空，说明左边没有比它小的，为-1，否则就是栈顶元素
                res[popIndex][0] = leftLessIndex;  //把popindex左边右边less的位置存起来
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        //数组遍历结束，清算栈中剩下的位置
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();  //把栈顶元素弹出来后，再peek()得到的就是原栈顶元素左边最近且less的位置（下标）。
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;  //右边已经没有比栈里元素小的了，-1。
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 1, 5, 6, 2, 7};
        getNearLessNoRepeat(a);
    }
}
