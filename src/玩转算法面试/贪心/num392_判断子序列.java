package 玩转算法面试.贪心;

public class num392_判断子序列 {
    //判断s是不是t的子序列
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0;  //索引s
        int j = 0;  //索引t
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int common = 0;
        while (i < sc.length && j < tc.length) {
            if (sc[i] == tc[j]) {
                common++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return common == sc.length ? true : false;
    }
}
