package 校招2020.快手;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //每n个一张图片
        int m = sc.nextInt();  //一共有m个待处理结果
        String[] arr = new String[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.next();
        }

        //计算
        int numv = 0;
        int q = 0;
        List<String> list = new ArrayList<>();  //记录前面的图片
        List<String> res = new ArrayList<>();
        while (q < m) {
            if (arr[q].charAt(0) == 'V') {
                res.add(arr[q]);
                numv++;
                if (numv == n - 1 && !list.isEmpty()) {
                    res.add(list.get(0));
                    list.remove(0);
                    numv = 0;
                }
                q++;
            } else {
                if (numv >= n - 1) {
                    res.add(arr[q]);
                    numv = 0;
                } else {
                    list.add(arr[q]);
                }
                q++;

            }
        }
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
