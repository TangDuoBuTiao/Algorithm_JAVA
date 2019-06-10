package 剑指offer;

public class 数组中的逆序对 {
    //时间复杂度过大！！！！
    public static int InversePairs(int[] array) {
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    ans++;
                }
            }
        }
        return ans % 1000000007;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 0, 2};
        System.out.println(InversePairs(a));
    }
}
