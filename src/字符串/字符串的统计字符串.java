package 字符串;
/*   《字符串的统计字符串》
 * 问题：给定一个字符串str, 返回str的统计字符串。
 *      Eg:str = aaabbcddddffc  返回res = a_3_b_2_c_1_d_4_f_2_c_1
 * 补充问题：给定一个字符串的统计字符串cstr,再给定一个整数index, 返回cstr所代表的原始字符串上的第index个字符。
 *      Eg:cstr = a_1_b_100  第50个字符是'b'
 */

public class 字符串的统计字符串 {
    public static String getCountStr(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chas = str.toCharArray();
        String res = "";
        int num = 1;
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] == chas[i - 1]) {
                num++;
                if (i == chas.length - 1) {            //最后一个字符是不是连续好几个
                    res += chas[i] + "_" + num;
                }
            } else {
                res += chas[i - 1] + "_" + num + "_";
                num = 1;
                if (i == chas.length - 1) {          //最后一个字符是不是就一个
                    res += chas[i] + "_" + num;
                }
            }
        }
        return res;
    }

    //补充问题
    public static char getCharAt(String str, int index) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chs = str.toCharArray();
        boolean stage = true;  //为true时表示遍历字符阶段，为false时表示遍历数字阶段
        int sum = 0;  //遍历到的位置在原始字符串中的位置
        int num = 0;  //数字阶段中的数字
        char cur = 0;
        for (int i = 0; i != chs.length; i++) {
            if (chs[i] == '_') {
                stage = !stage;
            } else if (stage) {   //遍历到的位置是字母
                sum += num;
                if (sum > index) {
                    return cur;
                }
                num = 0;
                cur = chs[i];
            } else {
                num = num * 10 + chs[i] - '0';
            }
        }
        return sum + num > index ? cur : 0;
    }

    public static void main(String[] args) {
        String str = "aaabbcddddffc";
        String cstr = "a_3_b_2_c_1_d_4_f_2_c_1";
        System.out.println(getCharAt(cstr, 13));
    }
}
