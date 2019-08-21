package 校招真题2019.网易;
/*
 * 输入描述：每个输入包含一个测试用例。
        每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
        接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
        接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
        保证不存在两项工作的报酬相同。
   输出：对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
   Eg:3 3
      1 100
      10 1000
      1000000000 1001
      9 10 1000000000
      -------------------
      100
      1000
      1001
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class 牛牛找工作 {

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //工作数量
        int m = sc.nextInt();  //小伙伴的数量
        int[] hard = new int[n + m];  //把工作难度和工作能力放在一起
        int[] salary = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>(); // <hard, salary>
        for (int i = 0; i < n; i++) {
            hard[i] = sc.nextInt();
            salary[i] = sc.nextInt();
            map.put(hard[i], salary[i]);
        }
        int[] ability = new int[m];
        for (int i = 0; i < m; i++) {
            ability[i] = sc.nextInt();
            hard[n + i] = ability[i];
            if(!map.containsKey(ability[i])){
                map.put(ability[i], 0);    //薪水先设置为0
            }
        }
        //计算
        Arrays.sort(hard);  //把工作难度和工作能力统一排序，从小到大。
        int max = 0;
        for (int i = 0; i < m + n; i++) {   //工作能力和工作难度
            max = Math.max(max, map.get(hard[i]));
            map.put(hard[i], max);   //更新map, key为难度，value不超过难度的最大薪水
        }
        for (int i = 0; i < m; i++) {
            System.out.println(map.get(ability[i]));
        }
    }
}
