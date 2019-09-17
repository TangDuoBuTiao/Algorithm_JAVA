package 玩转算法面试.贪心;


import java.util.Arrays;

public class num455_分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int si = s.length - 1;  //饼干索引
        int gi = g.length - 1;  //小朋友索引
        int res = 0;
        while (si >= 0 && gi >= 0){
            if (s[si] >= g[gi]) {
                gi--;
                si--;
                res++;
            } else {
                gi--;
            }
        }
        return res;
    }
}
