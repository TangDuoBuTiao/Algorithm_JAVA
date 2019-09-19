package leetcode;

public class num283_移动零 {
    //空间复杂度O(1)
    public void moveZeroes(int[] arr) {
        int k = 0; //保证区间[0,K)都是非零元素
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                arr[k] = arr[i];
                k++;
            }
        }
        for(int i = k; i < arr.length; i++){
            arr[i] = 0;
        }
    }
}
