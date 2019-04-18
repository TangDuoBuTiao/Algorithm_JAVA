package 字符串;
/*
 * leet-code 第8题
 */

public class atoi {

        public static String getNum(char[] chas){
            String num = "";
            boolean flag = true;
            for (int i = 0; i < chas.length; i++) {
                if (num == "" && chas[i] == ' ') {
                    continue;
                } else if ((chas[i] == '-' || chas[i] == '+') && flag) {
                    flag = false;
                    num += Character.toString(chas[i]);

                } else if (Character.isDigit(chas[i])) {
                    flag = false;
                    num += Character.toString(chas[i]);
                } else {
                    break;
                }
            }
            return (num.equals("+") || num.equals("-")) ? "" : num;
        }

        public static int myAtoi(String str) {
            if (str == null || str.equals("")) {
                return 0; //不能转
            }
            String num = getNum(str.toCharArray());
            char[] chas;
            if(num.equals("")){
                return 0;
            }else{
                chas = num.toCharArray();
            }
            boolean posi = chas[0] == '-' ? false : true;
            boolean nege = chas[0] == '+' ? false : true;
            int minq = Integer.MIN_VALUE / 10;   //用于判断转换过程中是否已经溢出
            int minr = Integer.MIN_VALUE % 10;
            int res = 0;
            int cur = 0;
            for (int i = posi && nege ? 0 : 1; i < chas.length; i++) {  //有符号从chas[1]开始，否则从chas[0]开始
                cur = '0' - chas[i];
                if ((res < minq) || res == minq && cur < minr) {
                    return posi ? Integer.MAX_VALUE : Integer.MIN_VALUE; //溢出
                }
                res = res * 10 + cur;
            }
            if (posi && res == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE; //溢出
            }
            return posi ? -res : res;
        }


    public static void main(String[] args) {
        String str = "   -5  aaa";
        System.out.println(getNum(str.toCharArray()));
        System.out.println(myAtoi(str));
    }
}
