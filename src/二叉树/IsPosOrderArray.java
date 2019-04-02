package 二叉树;
/*
 判断一个数组是否可能是二叉搜索树后序遍历的结果
 判断条件：比arr[end]大的在一堆，比arr[end]小的在一堆，
 */

public class IsPosOrderArray {

    public boolean isPosOrderarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }

    private boolean isPost(int[] arr, int start, int end) {
        if (start == end) {  //子数组中只剩一个数
            return true;
        }
        int less = -1;  //比end小那“部分”的最后一个
        int more = end; //比end大那“部分”的第一个
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;  //more赋值为第一次比end大元素的位置
            }
        }
        if (less == -1 || more == end) { //less = -1 表明前面所有的数都比end大（less没被赋过值）；more=end表明前面的数都比end小
            return isPost(arr, start, end - 1);
        }
        if (less != more - 1) {  //表明大的小的混在一起
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);  //拆分为两个数组，继续递归
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 6, 5, 7, 4};
        IsPosOrderArray f = new IsPosOrderArray();
        System.out.println(f.isPosOrderarray(a));
    }
}
