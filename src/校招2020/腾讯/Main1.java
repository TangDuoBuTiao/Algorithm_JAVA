package 校招2020.腾讯;


import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  //数组组数
        List<HashMap<Integer, Integer>> list = new ArrayList<>();
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            arr[i] = n;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if (map.containsKey(a)) {
                    map.put(a, map.get(a) + 1);
                } else {
                    map.put(a, 1);
                }
            }
            list.add(map);
        }

        //计算
        for (int i = 0; i < t; i++) {
            HashMap<Integer, Integer> map = list.get(i);
            boolean flag = true;
            for (Integer key : map.keySet()) {
                if(map.get(key) > (arr[i] / 2)){
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println("YES");
            }
        }
    }
}
