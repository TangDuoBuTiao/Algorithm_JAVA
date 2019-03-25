package 栈和队列;
/*
 窗口最大值数数组，
 解法：利用双端队列来实现窗口最大值更新，队列头部始终存放窗口最大值。
 */
import java.util.Arrays;
import java.util.LinkedList;

public class GetMaxWindow {
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];    //存放结果
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {   //新值比队尾元素大，队尾元素就出队，直到队列中元素大于新值或者队列为空，把新值加入队尾
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {  //队头元素等于i-w时，队头元素刚好不在窗口内，移出队列。
                qmax.pollFirst();
            }
            if (i >= w - 1) {  // 对于每次for循环，把窗口内最大元素存起来
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 5, 4, 3, 3, 6, 7};
        GetMaxWindow g = new GetMaxWindow();
        System.out.println(Arrays.toString(g.getMaxWindow(a, 3)));
    }
}
