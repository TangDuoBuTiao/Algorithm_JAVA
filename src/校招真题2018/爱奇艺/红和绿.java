package 校招真题2018.爱奇艺;
/*
  题目描述：牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。
          牛牛现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将会被覆盖。
          牛牛的目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。牛牛想知道他最少需要涂染几个正方形。
        如样例所示: s = RGRGR
        我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
  输入：输入包括一个字符串s,字符串s长度length(1 ≤ length ≤ 50),其中只包括'R'或者'G',分别表示红色和绿色。
  输出：输出一个整数,表示牛牛最少需要涂染的正方形数量
  Eg:RGRGR
     2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 红和绿 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        if (s.length() == 1) {
            System.out.println(0);
        }
        char[] chsr = s.toCharArray();
        int res = Integer.MAX_VALUE;
        int tmp = chsr[0] == 'R' ? 0 : 1;
        int tmpR = 0;
        int tmpG = 0;
        for (int i = 0; i < chsr.length; i++) {
            if (chsr[i] == 'G') {  //前面有多少个G 需要变成R
                tmpR++;
            }
            for (int j = i + 1; j < chsr.length; j++) {
                if (chsr[j] == 'R') {   //后面有多少个R 需要变成G
                    tmpG++;
                }
            }
            if ((tmpR + tmpG) == chsr.length) {   //R在一堆，G在一堆的情况
                res = Math.min(res, Math.min(tmpR, tmpG));
            }else{
                res = Math.min(res, tmpR + tmpG);
            }

        }
        System.out.println(res);
    }
}
