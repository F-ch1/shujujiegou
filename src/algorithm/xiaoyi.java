package algorithm;

import java.util.Scanner;

public class xiaoyi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = 0;
            for (int i = 0; i < n; i++) {
                 b = scanner.nextInt();
                if (a<b){
                    a=a+getmaxGCD(a,b);
                }else a=a+b;
            }
            System.out.println(a);
        }

    }

    private static int getmaxGCD(int a, int b) {
        int max=Math.max(a,b);
        int min=Math.min(a,b);
        int temp;
        while (min!=0){
            temp=max%min;
            max=min;
            min=temp;
        }
        return max;

    }
}
