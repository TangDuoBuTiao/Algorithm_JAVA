package 校招2020.腾讯;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String n_str = sc.next();
        int m = sc.nextInt();
        String[] strs = new String[m];
        for (int i = 0; i < m; i++) {
            strs[i] = sc.next();
        }
        //计算
        int res = 0;
        int i = 0;
        while (i < m) {
            if (n_str.contains(strs[i])) {
                int len = strs[i].length();
                int index1 = n / len;
                int index2 = n % len;
                StringBuilder sb = new StringBuilder();
                if (index1 > 1) {
                    sb.append(strs[i]);
                    sb.append(strs[i]);
                    String str = n_str.substring(0, len * 2);
                    if (str.equals(sb.toString())) {
                        res++;
                    }
                } else {
                    sb.append(strs[i]);
                    sb.append(strs[i].substring(0, index2));
                    if (n_str.equals(sb.toString())) {
                        res++;
                    }
                }
            }
            i++;
        }
        System.out.println(res);
    }
}

