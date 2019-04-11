package 递归和动态规划;
/*                                  《排成一条线的纸牌博弈问题》
 *问题：给定一个整型数组arr,代表数值不同的纸牌排成一条线，玩家A和玩家B都很聪明，规定A先拿，B后拿，每次只能拿走最左边或者最
 *      右边的纸牌，返回最后获胜者的分数。
 * 递归解法：定义两个递归函数：f(i,j)表示arr[i,.,j]这个排列上被人先拿；s(i,j)表示这个排列被人后拿。
 *        1.分析f(i,j):
 *              ①如果i=j表示就剩最后一张牌，先拿的人拿走，返回arr[i]
 *              ②如果i!=j, 先拿的人要么拿走arr[i],要么拿走arr[j]，先拿的人拿完后剩下arr[i+1,j]或者arr[i,j-1]
 *               先拿的人面对arr[i+1,j]或者arr[i,j-1]，就变为后拿的人，返回max(arr[i]+s(i+1,j), arr[j]+s(i,j-1))
 *        2.分析s(i,j):
 *              ①如果i=j,表示剩最后一张牌，后拿的人没得拿，返回0
 *              ②如果i!=j，对手（先拿的人）肯定会拿走arr[i]或者arr[j]，因为对手是绝顶聪明的人，肯定会把最坏的情况留
 *               给后拿的人，所以返回min(f(i+1,j), f(i,j-1))
 */

public class CardGameProblem {
    //方法一：暴力递归
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    public static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    //方法二:动态规划：建立两个N*N的dp矩阵f和s，f[i][j]表示f(i,j)的返回值
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int[][] f = new int[len][len];
        int[][] s = new int[len][len];
        for (int j = 0; j < len; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        /*    输出两个矩阵
        for (int i = 0; i < f.length; i++) {                    1 2 101 101
            for (int j = 0; j < f[i].length; j++) {             0 2 100 6
                System.out.printf("%-4d", f[i][j]);             0 0 100 100
            }                                                   0 0 0   4
            System.out.println();
        }
        System.out.println("----------------");
        for (int i = 0; i < s.length; i++) {                     0 1 2 6
            for (int j = 0; j < s[i].length; j++) {              0 0 2 100
                System.out.printf("%-4d", s[i][j]);              0 0 0 4
            }                                                    0 0 0 0
            System.out.println();
        }
         */
        return Math.max(f[0][len - 1], s[0][len - 1]);  //两个矩阵左上角元素的较大值
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 100, 4};
        System.out.println(win2(a));
    }

}
