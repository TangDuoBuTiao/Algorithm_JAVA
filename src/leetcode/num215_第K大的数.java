package leetcode;

public class num215_第K大的数 {


    public static void quickSort(int[] arr, int left, int right, int k) {
        //进行判断，如果左边索引比右边索引大，是不合法的，直接使用return结束这个方法
        if (left > right) {
            return;
        }
        //以最左边元素为基准元素
        int base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            //先把j从右往左移，直到找到比基准元素小的
            while (arr[j] >= base && i < j) {
                j--;
            }
            //把i从左往右移，直到找到比基准元素大的
            while (arr[i] <= base && i < j) {
                i++;
            }
            //交换i和j位置的元素
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        //跳出while循环表示i==j，此时交换基准元素这个元素
        arr[left] = arr[i];
        arr[i] = base;

        //递归调用quickSort
        if (i > k) {
            quickSort(arr, left, i - 1, k);
        } else if (i < k) {
            quickSort(arr, j + 1, right, k);
        } else {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        quickSort(arr, 0, arr.length - 1, arr.length - 2);
    }
}
