package 字符串;
/*            《将整数字符串转换为整数值》
 * 给定一个字符串str,如果str符合日常书写的整数格式，并且属于32位整数的范围，返回str所代表的整数值，否则返回0.
 */

import java.util.Scanner;

public class ConvertStrToNum {
    //首先检查是否符合日常书写整数形式
    public static boolean isValid(char[] chas) {
        if (chas[0] != '-' && (chas[0] < '0' || chas[0] > '9')) {  //A12
            return false;
        }
        if (chas[0] == '-' && (chas.length == 1 || chas[1] == '0')) { // - ||  -05
            return false;
        }
        if (chas[0] == '0' && chas.length > 1) {   // 012
            return false;
        }
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] < '0' || chas[i] > '9') {   //12A5
                return false;
            }
        }
        return true;
    }

    //转换字符串为数字，首先都先转换为负数，因为负数的|-2147483648|>|2147483647|,然后再根据posi的值决定转换后的符号
    public static int convert(String str) {
        if (str == null || str.equals("")) {
            return 0; //不能转
        }
        char[] chas = str.toCharArray();
        if (!isValid(chas)) {
            return 0; //不能转
        }
        boolean posi = chas[0] == '-' ? false : true;
        int minq = Integer.MIN_VALUE / 10;   //用于判断转换过程中是否已经溢出
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = posi ? 0 : 1; i < chas.length; i++) {  //负数从chas[1]开始，正数从chas[0]开始
            cur = '0' - chas[i];
            if ((res < minq) || res == minq && cur < minr) {
                return 0; //溢出
            }
            res = res * 10 + cur;
        }
        if (posi && res == Integer.MIN_VALUE) { //转换后是-2147483648
            return 0; //溢出
        }
        return posi ? -res : res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入字符串：");
        String str = sc.nextLine();
        System.out.println("转换结果：" + convert(str));
    }

}
