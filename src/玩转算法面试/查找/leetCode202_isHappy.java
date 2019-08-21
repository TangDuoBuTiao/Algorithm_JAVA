package 玩转算法面试.查找;
/*
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * 输入: 19
   输出: true
   解释:
       1^2 + 9^2 = 82
       8^2 + 2^2 = 68
       6^2 + 8^2 = 100
       1^2 + 0^2 + 0^2 = 1
 */
import java.util.HashMap;
public class leetCode202_isHappy {
    public static boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        while (true) {
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            }
            if(map.containsKey(sum)){
                return false;
            }else{
                map.put(sum, 1);
            }
            n = sum;
            sum = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
