package 剑指offer;

public class 变态跳台阶 {
    public static int JumpFloorII(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int ans = 0;
        for (int i = 0; i < target; i++) {
            ans += JumpFloorII(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }
}
