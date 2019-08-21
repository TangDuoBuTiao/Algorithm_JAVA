package 玩转算法面试.数组;

public class test {

    public static boolean isPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }
        char[] chs = s.toCharArray();
        int l = 0;
        int r = chs.length - 1;
        while (l < r) {
            if (isValid(chs[l]) && isValid(chs[r])) {
                if (chs[l] == chs[r]) {
                    l++;
                    r--;
                } else if (!Character.isDigit(chs[l]) && !Character.isDigit(chs[r])) {  //是大小写字母一样
                    if(Math.abs((int)chs[l] - (int)chs[r]) == 32){
                        l++;
                        r--;
                    }else{
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (!isValid(chs[l])) {
                l++;
            } else if (!isValid(chs[r])) {
                r--;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    //判断是数字，字符还是其他
    public static boolean isValid(char c) {
        if ((97 <= (int) c && (int) c <= 122) ||
                (65 <= (int) c && (int) c <= 90) ||
                (48 <= (int) c && (int) c <= 57)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
