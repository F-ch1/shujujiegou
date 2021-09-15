package algorithm;

public class Hannuota {
    public static void main(String[] args) {
     hannuota(3, 'a', 'b', 'c');

    }

    public static void hannuota(int num,char a,char b,char c){

                if (num==1){
                    System.out.println("第一个盘子"+a+"->"+c);

                }else {
                    //将a上面n-1个盘子从a——>b
                    hannuota(num-1, a,c,b);
                    //将最下面的盘子从a到c
                    System.out.println("第"+num+"个盘子从"+a+"->"+c);
                    //将b的所有盘子移到c
                    hannuota(num-1, b,a, c);
                }

    }
}
