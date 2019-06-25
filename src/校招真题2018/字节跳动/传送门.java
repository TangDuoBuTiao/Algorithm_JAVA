package 校招真题2018.字节跳动;
/*
 问题描述：存在n+1个房间，每个房间依次为房间1 2 3...i，每个房间都存在一个传送门，i房间的传送门可以把人传送到
         房间pi(1<=pi<=i),现在路人甲从房间1开始出发(当前房间1即第一次访问)，每次移动他有两种移动策略：
            A. 如果访问过当前房间 i 偶数次，那么下一次移动到房间i+1；
            B. 如果访问过当前房间 i 奇数次，那么移动到房间pi；
         现在路人甲想知道移动到房间n+1一共需要多少次移动；
 输入：第一行包括一个数字n(30%数据1<=n<=100，100%数据 1<=n<=1000)，表示房间的数量，
      接下来一行存在n个数字 pi(1<=pi<=i), pi表示从房间i可以传送到房间pi。
 输出：输出一行数字，表示最终移动的次数，最终结果需要对1000000007 (10e9 + 7) 取模。
 Eg:2
    1 2
    4

 解析：1. 走到i时，前面i-1个门肯定都走过偶数次
      2. 走到i时，dp[i] = dp[i-1] + 1 ,触发条件是第二次走到i-1
      3. 第二次走到i-1,需要多少步呢？
         答：第一次走到i-1,步数需要+1传送到p[i-1], p[i-1]走到i-1需要dp[i-1] - dp[p[i-1]]
      总上所述：dp[i] = dp[i-1] + dp[i-1] - dp[p[i-1]] + 1 + 1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 传送门 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String[] str = input.readLine().split(" ");
        int[] p = new int[n + 1];   //p数组从1开始
        for (int i = 1; i <= n ; i++) {
            p[i] = Integer.parseInt(str[i - 1]);
        }
        long mod = 1000000007;
        long[] dp = new long[n + 2];  //从1开始，门的编号到n+1, 故需要走到n+2
        dp[1] = 0;  //从第一个门开始
        for(int i = 2; i <= n + 1; i++){
            dp[i] = dp[i - 1] * 2 % mod - dp[p[i - 1]] + 2;
        }
        System.out.println(dp[n + 1] % mod);
    }
}
