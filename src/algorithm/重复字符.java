package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 重复字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();//得到控制台输入字符串
        char[] chars = s.toCharArray();//将输入字符串转化为字符串数组
        HashSet<Character> characters = new HashSet<>();//创建hashset集合
        StringBuilder stringBuilder =new StringBuilder();//创建输出字符串结果集
        for (int i=0;i<chars.length;i++){
            char c = chars[i];//得到每个字符
            if (!characters.contains(c)){//如过hashset集合没有这个字符就加入字符并拼接
                characters.add(c);//如过hashset集合没有这个字符就加入字符
                stringBuilder.append(c);//字符串拼接只出现一次的字符
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
