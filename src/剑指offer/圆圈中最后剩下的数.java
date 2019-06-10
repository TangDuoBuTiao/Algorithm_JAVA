package 剑指offer;

import java.util.LinkedList;

public class 圆圈中最后剩下的数 {
    public static int LastRemaining_Solution(int n, int m) {
        //先把数存在LinkedList中
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1   ){
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.size() == 1 ? list.get(0) : -1;

    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 2));
    }
}
