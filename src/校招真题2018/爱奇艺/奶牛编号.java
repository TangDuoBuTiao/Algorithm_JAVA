package 校招真题2018.爱奇艺;
/*
 问题描述：牛牛养了n只奶牛,牛牛想给每只奶牛编号,这样就可以轻而易举地分辨它们了。 每个奶牛对于数字都有自己的喜好,
         第i只奶牛想要一个1和x[i]之间的整数(其中包含1和x[i])。
         牛牛需要满足所有奶牛的喜好,请帮助牛牛计算牛牛有多少种给奶牛编号的方法,输出符合要求的编号方法总数。
 输入：输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示奶牛的数量 第二行为n个整数x[i](1 ≤ x[i] ≤ 1000)
 输出：输出一个整数,表示牛牛在满足所有奶牛的喜好上编号的方法数。因为答案可能很大,输出方法数对1,000,000,007的模。
 Eg:4
    4 4 4 4
    24
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class 奶牛编号 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(input.readLine());
        String[] str = input.readLine().split(" ");
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        long res = arr[0];
        for (int i = 1; i < len; i++) {
            res = res * (arr[i] - i) % 1000000007;
        }
        System.out.println(res);
    }
}
