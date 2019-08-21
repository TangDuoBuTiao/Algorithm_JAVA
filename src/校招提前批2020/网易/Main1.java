package 校招提前批2020.网易;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    static List<String> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = input.readLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        permute(arr, 0);
        String str = s + " ";
        for(int i = 0; i< res.size(); i++){
            if(res.get(i).equals(s)){
                System.out.println(res.get(res.size() - 1 - i));
                return;
            }
        }

    }
    public static void permute(int[] array, int start){
        if(start == array.length){
            String s = "";
            for(int i = 0; i < array.length; i++){
                s += String.valueOf(array[i]) + " ";
            }
            res.add(s.trim());
        }else{
            for(int i = start; i < array.length; i++){
                swap(array, start, i);
                permute(array, start + 1);
                swap(array, start, i);
            }
        }
    }
    public static void swap(int[] arr, int s, int i){
        int t = arr[s];
        arr[s] = arr[i];
        arr[i] = t;
    }



}
