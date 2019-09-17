package 校招2020.爱奇艺;


import java.util.Scanner;

public class Main3 {
    static int res = 0;
    static int bsum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //a个红 1
        int m = sc.nextInt();  //b个蓝 0
        int[] arr = new int[n + m];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        perm(arr, 0, arr.length);
        double ans = bsum / res;
        System.out.println(String.format("%.2f", ans));
    }

    public static boolean awin(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if(num[i % 3] == 1 && num[i] == 1){
                return true;
            }
        }
        return false;
    }

    //求数组全排列
    public static void perm(int[] nums, int start, int len) {
        //判断递归出口，当start == len - 1时，也就是要做的全排列只有一个值 ，那么就可以输出了

        if (start == len - 1) {
            res++;
            if(!awin(nums)){
                bsum++;
            }
            //System.out.println(Arrays.toString(nums));
        } else {

            for (int i = start; i < len; i++) {
                swap(nums, start, i);//通过交换，依次将每个数放在第一位
                perm(nums, start + 1, len);//递归调用
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
