package 字符串;
/*  《数组中两个字符串的最小距离》
 * 问题：给定一个字符串数组str, 再给定两个字符串str1和str2,返回在strs中str1和str2的最小距离，
 *      如果str1或str2为null, 或不在strs中，返回-1
 * 补充问题：如果查询次数过多，如何把每次查询时间复杂度将为O(1)
 */

public class MinDistance {
    //主问题
    public static int minDistance(String[] strs, String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        if (str1 == str2) {
            return 0;
        }
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(str1)) {
                min = Math.min(min, last2 == -1 ? min : i - last2);
                last1 = i;
            }
            if (strs[i].equals(str2)) {
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    //补充问题：

    public static void main(String[] args) {
        String[] strs = {"a", "b", "c", "d", "e", "d", "f"};
        System.out.println(minDistance(strs, "c", "g"));
    }
}
