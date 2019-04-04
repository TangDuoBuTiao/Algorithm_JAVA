package 二叉树;
/*
给定一棵树的前序和中序数组，通过这两个数组直接得到后序遍历数组，（不通过建树的方法实现）
 */

import java.util.Arrays;
import java.util.HashMap;

public class GetPosArray {

    public int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
        return pos;
    }

    public int setPos(int[] pre, int pi, int pj, int[] in, int ni, int nj,
                      int[] pos, int si, HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return si;
        }
        pos[si--] = pre[pi];
        int i = map.get(pre[pi]);  //根据前序的头结点，找到其在中序数组中的位置
        si = setPos(pre, pj - nj + i + 1, pj, in, i + 1, nj, pos, si, map);
        return setPos(pre, pi + 1, pi + i - ni, in, ni, i - 1, pos, si, map);
    }

    public static void main(String args[]) {
        int preArr[] = {1, 2, 4, 5, 3, 6, 7};
        int[] inArr = {4, 2, 5, 1, 6, 3, 7};
        GetPosArray g = new GetPosArray();
        System.out.println(Arrays.toString(g.getPosArray(preArr, inArr)));
    }


}
