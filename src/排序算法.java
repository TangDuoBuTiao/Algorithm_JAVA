import java.util.Arrays;

public class 排序算法 {


    /*
    冒泡排序：比较相邻元素，前者比后者大，交换之。时间复杂度最好：O(n), 最坏O(n^2)
    */
    public static void Bubble(int a[]) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        for (int k = 0; k < len; k++) {
            System.out.print(a[k] + "  ");
        }
    }

    public static void myBubble(int a[]) {     //自己想的
        int len = a.length;
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        for (int k = 0; k < len; k++) {
            System.out.print(a[k] + "  ");
        }
    }

    /*
    快速排序
     */
    public static void quickSort(int a[], int low, int hight) {
        if (low > hight) {  // 递归算法出口
            return;
        }
        int i = low;
        int j = hight;

        int key = a[low];   // 被比较的元素
        while (i < j) {
            while (i < j && a[j] > key) {    //从右向左找到小于key的数
                j--;
            }
            while (i < j && a[i] <= key) {    // 从左向右找大于key的数
                i++;
            }
            if (i < j) {    //交换
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        // 调整key的位置
        int tmp = a[i];
        a[i] = a[low];
        a[low] = tmp;

        // 对key左边的数快排
        quickSort(a, low, i - 1);
        // 对key右边的数快排
        quickSort(a, i + 1, hight);

    }

    public static void main(String[] args) {
        int nums[] = {5, 1, 4, 2, 3};
        //Bubble(nums);
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
