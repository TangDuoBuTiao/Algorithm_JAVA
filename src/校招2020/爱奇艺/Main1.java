package 校招2020.爱奇艺;


import java.util.Scanner;

public class Main1 {

    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int[] a = new int[n - 1];   //01串
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextInt();
        }
        perm(arr, a, 0, arr.length);
        double m = Math.pow(10, 9)+7;
        System.out.println(res);
    }

    //判断数组num是不是符合01数组a
    public static boolean isPrint(int[] num, int[] a) {
        for (int i = 1; i < num.length; i++) {
            if ((a[i - 1] == 1 && num[i - 1] > num[i]) || (a[i - 1] == 0 && num[i - 1] < num[i])) {
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    //求数组全排列
    public static void perm(int[] nums, int[] a, int start, int len) {
        //判断递归出口，当start == len - 1时，也就是要做的全排列只有一个值 ，那么就可以输出了
        if(!isPrint(nums, a)){
            return;
        }
        if (start == len - 1) {
            if(isPrint(nums, a)){
                res++;
            }
         //   System.out.println(Arrays.toString(nums));
        } else {

            for (int i = start; i < len; i++) {
                swap(nums, start, i);//通过交换，依次将每个数放在第一位
                perm(nums, a, start + 1, len);//递归调用
                swap(nums, start, i);//交换回来，保证原数组不会变，以进行下一轮全排列
            }
        }
    }

    //交换数组中的两个值
    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
