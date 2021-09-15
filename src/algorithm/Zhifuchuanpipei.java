package algorithm;

public class Zhifuchuanpipei {
    public static void main(String[] args) {
        String str1="abcdefgh";
        String str2="ef";
        int index = pipei(str1, str2);
        System.out.println(index);
    }

    private static int pipei(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1len = s1.length;
        int s2len = s2.length;
        int i=0;
        int j=0;
        while (i<s1len&&j<s2len){
            if (s1[i]==s2[j]){
                i++;
                j++;
            }else {
                i=i-(j-1);//下标从0开始所以要减一，从已经匹配未成功的后部分开始匹配
                j=0;
            }

        }
        if (j==s2len){
            return i-j;
        }else {
            return -1;
        }
    }
}
