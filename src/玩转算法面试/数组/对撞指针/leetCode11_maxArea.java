package 玩转算法面试.数组.对撞指针;
/*
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) .
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */

public class leetCode11_maxArea {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while(l < r){
            if(height[l] <= height[r]){
                res = Math.max(res, height[l] * (r - l + 1));
                l++;
            }else{
                res = Math.max(res, height[r] * (r - l + 1));
                r--;
            }
        }
        return res;
    }
}
