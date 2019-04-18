package 字符串;
/*                       《在有序但含有空的数组中查找字符串》
 * 问题：给定一个字符串数组strs[]，在strs中，有些位置为null, 在不为null的位置上，其他字符按照字典顺序由小到大依次出现。
 *      再给定一个字符串str, 请返回str在strs中出现的最左的位置。
 * 解法：使用二分查找 mid = (left + right) / 2
 */

public class GetIndexOfString {
    public int getIndex(String[] strs, String str) {
        if (strs == null || strs.length == 0 || str == null) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = strs.length - 1;
        int mid = 0;
        int i = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (strs[mid] != null && strs[mid].equals(str)) {
                res = mid;
                right = mid - 1;
            } else if (strs[mid] != null) {
                if (strs[mid].compareTo(str) < 0) {  //说明不在左半区，需在右半区查找
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                i = mid;
                while (strs[i] == null && --i >= left)  //从mid开始，从右到左遍历左半区
                    ;
                    if (i < left || strs[i].compareTo(str) < 0) { //发现第一个不为null的位置i
                        left = mid + 1;
                    } else {
                        res = strs[i].equals(str) ? i : res;
                        right = i - 1;      //继续向左找
                }
            }
        }
        return res;
    }
}
