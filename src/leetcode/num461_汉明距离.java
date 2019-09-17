package leetcode;

public class num461_汉明距离 {
    public int hammingDistance(int x, int y) {
        //异或运算，相同为0， 不同为1， 统计异或之后1的个数就行
        int res = x ^ y;
        int count = 0;
        while (res != 0) {
            count++;
            res = res & (res - 1);
        }
        return count;
    }
}
