package 剑指offer;

import java.util.ArrayList;
import java.util.Vector;

public class 数值的整数次方 {
    public static double Power(double base, int exponent) {
        double ans = 1;
        int flag = exponent;
        while (exponent != 0) {
            ans = ans * base;
            if (exponent > 0) {
                exponent--;
            } else {
                exponent++;
            }
        }
        return flag > 0 ? ans : 1 / ans;
    }



    public static void main(String[] args) {
        // System.out.println(Power(2, -3));
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    }
}
