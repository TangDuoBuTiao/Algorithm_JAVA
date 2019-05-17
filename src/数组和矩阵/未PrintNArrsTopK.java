package 数组和矩阵;
/*         《打印N个数组整体最大的Top K》
 *  问题：有N个长度不一的数组，所有的数组都是有序的，请从大到小打印这N个数组整体最大的前K个数。
 *  要求：如果所有数组的元素个数小于K, 则从大到小打印所有数
 *       要求时间复杂度为O(KlogN)
 */

public class 未PrintNArrsTopK {
    public class HeapNode {
        public int value;     //值是什么
        public int arrNum;    //来自哪个数组
        public int index;     //来自数组的哪个位置

        public HeapNode(int value, int arrNum, int index) {
            this.value = value;
            this.arrNum = arrNum;
            this.index = index;
        }
    }

//    public void printTopK(int[][] matrix, int topK) {
//        int heapSize = matrix.length;
//        HeapNode[] heap = new HeapNode(heapSize);
//        for (int i = 0; i != heapSize; i++) {
//            int index = matrix[i].length-1;
//            heap[i] = new HeapNode(matrix)
//        }
//    }

}
