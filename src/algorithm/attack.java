package algorithm;

import java.util.Scanner;

public class attack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hp = scanner.nextInt();//hp
        int normalattack = scanner.nextInt();//普通攻击
        int bufferattack = scanner.nextInt();//蓄力攻击需要2回合
        int res =0;//次数
        if (normalattack>=bufferattack/2){
            res=hp/normalattack;
            if (hp/normalattack!=0){
                res++;
        }else if (normalattack<=bufferattack/2){
            res=hp/bufferattack*2;
                if (hp/bufferattack>normalattack){
                    res+=2;
                }else if (hp/bufferattack<normalattack){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
