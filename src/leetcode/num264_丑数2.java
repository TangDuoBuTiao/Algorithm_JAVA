package leetcode;
/*
 * 找到第n个丑数
 */

public class num264_丑数2 {
    public static int nthUglyNumber(int n) {
        int cur = 1;
        int count = 0;
        while (count != n) {
            if (isUgly(cur)) {
                count++;
            }
            cur++;
        }
        return cur - 1;
    }

    public static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        boolean flag = true;
        while (flag) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                flag = false;
            }
            if (num == 1) {
                flag = false;
            }
        }
        return num == 1 ? true : false;
    }
    public static void main(String[] args){
        System.out.println(nthUglyNumber(1));
    }
}
