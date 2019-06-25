package 校招真题2018.字节跳动;
/*
 问题描述：
        有一个仅包含’a’和’b’两种字符的字符串s，长度为n，每次操作可以把一个字符做一次转换（把一个’a’设置为’b’，
        或者把一个’b’置成’a’)；但是操作的次数有上限m。
        问在有限的操作数范围内，能够得到最大连续的相同字符的子串的长度是多少。
 输入：第一行两个整数 n , m (1<=m<=n<=50000)，第二行为长度为n且只包含’a’和’b’的字符串s。
 输出：输出在操作次数不超过 m 的情况下，能够得到的 最大连续 全’a’子串或全’b’子串的长度。
 Eg：8 1
    aabaabaa
    5
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 最大连续相同子串 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = input.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        String str = input.readLine();

        char[] chstr = str.toCharArray();
        int maxl = 0;  //记录最大长度
        int l = 0;     //窗口左指针
        int r = 0;     //窗口右指针
        int an = 0;    //当前窗口内'a'的数量
        int bn = 0;    //当前窗口内'b'的数量
        while (r < n) {
            if (chstr[r] == 'a') {
                an++;
            } else {
                bn++;
            }
            if (an <= m || bn <= m) {  //如果窗口内的'a'或'b'的数量都在可调整范围内，窗口一直向右扩大
                r++;
            }else{
                maxl = Math.max(maxl, (r - l));  //如果当前窗口内的‘a’,‘b’达到可调整上限，就计算长度
                if(chstr[l] == 'a'){
                    l++;   //窗口开始向右滑动
                    an--;
                }else{
                    l++;
                    bn--;
                }
                r++;  //滑动
            }
        }
        maxl = Math.max(maxl, (r - l));
        System.out.println(maxl);
    }
}
