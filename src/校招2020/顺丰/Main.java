package 校招2020.顺丰;

// 后面的数比前面的数大

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        PriorityQueue<Integer>headp=new PriorityQueue<>((n1,n2)->n1-n2);
        for(int i=0;i<n;i++){
            if(!headp.contains(arr[i]))
                headp.offer(arr[i]);
        }
        System.out.println(headp.size());
    }



}
