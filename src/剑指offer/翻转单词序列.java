package 剑指offer;

public class 翻转单词序列 {

    public static String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] s = str.split(" ");
        String res = "";
        for(int i = s.length - 1; i > 0; i--){
            res += s[i] + " ";
        }
        return res + s[0];
    }

    public static void main(String[] args){
        System.out.println(ReverseSentence(" "));
    }
}
