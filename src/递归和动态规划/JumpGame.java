package 递归和动态规划;

public class JumpGame {
    public static int jump(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int jump = 0;     //记录跳几次
        int cur = 0;      //表示目前能达到的最远位置
        int next = 0;     //表示当前可跳范围内，再跳一次最远能跳到哪个位置
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {   //如果跳不到位置i,就多跳一下
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 3, 1, 1, 4};
        System.out.println(jump(a));
    }
}
