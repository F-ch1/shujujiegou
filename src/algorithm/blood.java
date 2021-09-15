package algorithm;

import java.util.Arrays;
//判断血型
public class blood {
    public static void main(String[] args) {
        String father="A";
        String mother="A";
        String[] check = check(father, mother);
        System.out.println(Arrays.toString(check));

    }

    private static String[] check(String father, String mother) {
        String[] result={""};
        if (father == "O" && mother == "O") {
            String[] son ={"o","a"};
            return son;
        }else if (father=="A"&&mother=="A"){
            String[] son1={"A"};
            return son1;
        }
            return result;
    }
}
