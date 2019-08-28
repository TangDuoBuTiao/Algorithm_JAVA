package 校招2020.贝壳;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(arr[0][1]);
        for (int i = 1; i < n; i++) {
            int len = list.size();
            for (int j = 0; j < len; j++) {
                int tmp = list.get(j);
                if(j % 2 == 0){
                    list.add(tmp + arr[i][1]);
                    list.add(tmp + arr[i][0] + arr[i][2]);
                }else{
                    list.add(tmp + arr[i][0]);
                    list.add(tmp + arr[i][1] + arr[i][2]);
                }
            }
            double len2 = Math.pow(2, i - 1);
            for(int p = 0; p < len2; p++){
                list.remove(p);
            }
        }
        System.out.println(list);
//        int res = Integer.MAX_VALUE;
//        double s = Math.pow(2, n - 1);
//        for(int k = list.size() - 1; k >= list.size() - s; k--){
//            res = Math.min(res, list.get(k));
//        }
//        System.out.println(res);
    }
}
