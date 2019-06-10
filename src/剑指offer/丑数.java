package 剑指offer;

public class 丑数 {

    public static int GetUglyNumber_Solution(int index) {
        int ugly[] = new int[index];   //用于存放丑数
        ugly[0] = 1;   //第一个丑数是1
        int count = 1;    //计数器
        int mul2 = 0;
        int mul3 = 0;
        int mul5 = 0;
        int min = 0;
        while (count < index) {
            min = compareMin(ugly[mul2] * 2, ugly[mul3] * 3, ugly[mul5] * 5);
            ugly[count] = min;   //把3个数中的最小值加入ugly数组

            while (ugly[mul2] * 2 <= ugly[count]) {
                mul2++;
            }
            while (ugly[mul3] * 3 <= ugly[count]) {
                mul3++;
            }
            while (ugly[mul5] * 5 <= ugly[count]) {
                mul5++;
            }
            count++;
        }
        return ugly[index - 1];
    }

    //比较三个数中最小值
    public static int compareMin(int i, int j, int k) {
        if (i <= j) {
            if (i <= k) {
                return i;
            } else {
                return k;
            }
        } else if (j <= k) {
            return j;
        } else {
            return k;
        }
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }
}
