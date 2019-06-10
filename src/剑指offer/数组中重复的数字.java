package 剑指offer;

public class 数组中重复的数字 {
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        int[] index = new int[length];
        for (int i = 0; i < length; i++) {
            index[numbers[i]]++;
            if (index[numbers[i]] > 1) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 5, 3};
        int[] b = new int[1];
        System.out.println(duplicate(a, 6, b));
        System.out.println(b[0]);
    }
}
