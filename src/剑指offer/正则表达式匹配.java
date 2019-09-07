package 剑指offer;

public class 正则表达式匹配 {

        public static boolean matchPattern(char[] strChar, char[] patternChar) {
            // check

            int strIndex = 0;
            int patternIndex = 0;
            while (strIndex < strChar.length && patternIndex < patternChar.length) {
                //首先做字符匹配和.匹配。然后，做*匹配
                if (strChar[strIndex] == patternChar[patternIndex] || patternChar[patternIndex] == '.') {
                    strIndex++;
                    patternIndex++;
                } else if(patternChar[patternIndex+1]=='*') {
                    patternIndex++;
                } else {
                    return false;
                }

                if (patternIndex < patternChar.length && patternChar[patternIndex] == '*') {
                    char prev = patternChar[patternIndex - 1];
                    if (strIndex < strChar.length && prev == strChar[strIndex]) {
                        while (strIndex < strChar.length && prev == strChar[strIndex]) {
                            strIndex++;
                        }
                        patternIndex++;
                    } else {
                        patternIndex++;
                    }
                }
            }

            if (strIndex == strChar.length && patternIndex == patternChar.length) {
                return true;
            } else {
                return false;
            }
        }
        public static void main(String[] args){
            char[] s1 = {};
            char[] s2 = {'.', '*'};
            System.out.println(matchPattern(s1, s2));
        }

}
