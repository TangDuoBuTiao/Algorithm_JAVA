package 校招真题2018;
/*
 * 问题：六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，
 *      当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，
 *      使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 *
 * 输入：第一行：n，表示h数组元素个数
        第二行：n个h数组元素
        第三行：m，表示w数组元素个数
        第四行：m个w数组元素
   输出: 上台表演学生数
 */

import java.util.Arrays;
import java.util.Scanner;

public class 六一儿童节 {

    public static void main(String[] args) {
        //接收输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = sc.nextInt();
        }
        //把w和h数组从小到大排序
        Arrays.sort(w);
        Arrays.sort(h);
        int res = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if(w[i] >= h[j]){
                res++;
                i++;
                j++;
            }else{
                i++;
            }
        }
        System.out.println(res);

    }
}
