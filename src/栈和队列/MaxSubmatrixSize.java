package 栈和队列;

/*
 给定一个整型矩阵map,其中的值只有0和1，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量。
 解法：统计以当前行作为底的情况，每个位置往上的1的个数，使用高度数组height表示，
       数组height可以看成是直方图，转化为求直方图中最大子矩形的面积，
       这个问题可以转化为  栈和队列.getNearLess方法中使用单调栈结构求解。
 */

import java.util.Stack;

public class MaxSubmatrixSize {

    public static int maxSubmatrixSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);  //每遍历一行后，就统计当前直方图的矩形面积
        }

        return maxArea;
    }

    public static int maxRecFromBottom(int[] height) { // 对于每个高度数组，求每个位置能形成矩形的面积
        if (height == null || height.length == 0) {
            return 0;
        }
        int area = 0;
        Stack<Integer> stack = new Stack<>();   //单调栈，从栈顶到栈底递减
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {  //新元素比栈顶元素小
                int j = stack.pop();       //栈顶元素出栈，因为此时右边的i位置和左边的k位置元素都离j最近且比j位置小，矩形的宽度就是（i-k-1）
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];    //j位置当前的矩形面积
                area = Math.max(area, curArea); //每求一个位置的矩形面积，就更新最大面积
            }
            stack.push(i);
        }
        //遍历完height后，清算栈中元素
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];  //往右已经找不到比当前位置元素更小的了，直接用height.length表示向右可以扩展到的边界。
            area = Math.max(curArea, area);
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.println(maxSubmatrixSize(a));
    }
}
