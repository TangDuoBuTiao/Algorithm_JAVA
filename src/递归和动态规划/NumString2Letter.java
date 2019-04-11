package 递归和动态规划;
/*
 *问题：给定一个全部由数字组成的字符串str,如果str中某一个或相邻两个字符组成的子串在1~26之间，则这个子串可以转化为字母。
 *     规定1->A, 2->B, ..,26->Z, 0没有对应的字母。求str有多少种不同的转换结果，并返回种数。
 * 解法：令p(i)为str[i,.,N-1]可能转换的种数，比如str = "111123", p(4)对应的是str[4,5] = "23",
 *      转换的情况是2->B, 3->C; 23->W; P(4) = 2; 同理p(5) = 1（只有3->C这一种）,p(6)=1 代表整体已经转换完了，合法种数为1
 *      1.如果只存在'A'-'I'的转换，p(i) = p(i+1)
 *      2.如果还存在相邻两个组合转换的情况，p(i) = p(i) + p(i+2)
 *         Eg:知道p(6)和p(5) 可算出p(4),...,知道p(1)和p(2)可算出p(0)
 */

public class NumString2Letter {
    public static int num(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chs = str.toCharArray();
        int cur = chs[chs.length - 1] == '0' ? 0 : 1;  //判断最后一个数是不是0,如果不是0，则字符串整体可以组成一个数
        int next = 1;
        int tmp = 0;
        for (int i = chs.length - 2; i >= 0; i--) {  //从倒数第二个字符开始
            if (chs[i] == '0') {
                next = cur;
                cur = 0;
            } else {
                tmp = cur;
                if (chs[i] - '0' * 10 + chs[i + 1] - '0' < 27) {  //存在相邻组合转换的可能性
                    cur += next;
                    System.out.printf("%-4d", cur);
                }
                next = tmp;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        String str = "111123";
        System.out.println("\n转换种数: " + num(str));
    }
}
