package leetcode;
/*
 * 判断一个数是不是丑数
 */

public class num263_丑数 {
    public static boolean isUgly(int num) {
        if(num <= 0){
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
        System.out.println(isUgly(1));
    }
}
