package 校招2020.哔哩哔哩;

import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //计算
        int i = 0;
        int j = 0;
        int sum = arr[0];
        int min = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (i < n) {
            if (j + 1 < n && sum + arr[j + 1] <= s) {  //向右试探
                j++;
                sum += arr[j];
            } else {
                min = Math.min(min, j - i + 1);
                if (map.containsKey(sum)) {
                    if(map.get(sum) <= min){
                        map.put(sum, min);
                    }
                }else{
                    map.put(sum, min);
                }
                sum -= arr[i];
                i++;
            }
        }
        int res = n;
        for(Integer key : map.keySet()){
            System.out.print(key + " " + map.get(key));
            System.out.println();
            if(map.get(key) == n){
                System.out.println(-1);
                return;
            }
            if(key <= s){
                res = map.get(key);
            }else{
                res = Math.min(res, map.get(key));
            }
        }
        System.out.println(res);
    }
}
