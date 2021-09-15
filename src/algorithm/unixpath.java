package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class unixpath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String simplepath = simplepath(s);
        System.out.println(simplepath);
    }

    private static String simplepath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");//将字符串分割为多个字符（不包括分割符号）
        for (String s:split
             ) {
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else if (!s.equals(".")&&!s.equals("")){
                stack.push(s);
            }
        }
        String res ="";
        while (!stack.isEmpty()){
            res="/"+stack.pop()+res;
        }
        while (res.length()==0){
            return "/";
        }
        return res;
    }
}
