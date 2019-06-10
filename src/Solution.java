import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static int StrToInt(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] ch = str.toCharArray();
        if (!isValid(ch)) {
            return 0;
        }
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        boolean posi = ch[0] == '-' ? false : true;
        int res = 0;
        int cur = 0;

        for (int i = (ch[0] == '-' || ch[0] == '+') ? 1 : 0; i < ch.length; i++) {
            cur = '0' - ch[i];
            if (res < minq || (res == minq && cur < minr)) {
                return 0;
            }
            res = res * 10 + cur;
        }
        if (posi && res == Integer.MIN_VALUE) {
            return 0;
        }
        return posi ? -res : res;
    }

    public static boolean isValid(char[] charStr) {
//        if (charStr[0] != '-'  && (charStr[0] < '0' || charStr[0] > '9')) {  //A12
//            return false;
//        }
//        if (charStr[0] != '+'  && (charStr[0] < '0' || charStr[0] > '9')) {  //A12
//            return false;
//        }
//        if (charStr[0] == '-' && (charStr.length == 1 || charStr[1] == '0')) {  // - || -05
//            return false;
//        }
//        if (charStr[0] == 0 && charStr.length > 1) {
//            return false;
//        }
        for (int i = 1; i < charStr.length; i++) {
            if (charStr[i] < '0' || charStr[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Solution s = new Solution();
        System.out.println(s.StrToInt("+123"));
    }
}