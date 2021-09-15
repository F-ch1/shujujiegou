package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class hongbao {
    public static void main(String[] args) {
        int[] gifts = new int[]{1,2,3,2,2};
        int n = 5;
        Arrays.sort(gifts);
        int mid= gifts[n/2];
        int count =0;
        for (int i = 0; i < n; i++) {
            if (gifts[i]==mid){
                count++;
            }
        }
      if (count>2/n){
          System.out.println(mid);
      }else System.out.println("0");
   /*     int[] gifts = new int[]{1,2,3,2,2};
        int n = 5;

        int value = getValue(gifts, n);
        System.out.println(value);*/

    }

    /*private static int getValue(int[] gifts, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int gift = gifts[i];
            if (map.containsKey(gift)) {
                count =map.get(gift) + 1;
                map.put(gift, count);
            } else {
                count++;
                map.put(gift, count);
            }
            if (count > n / 2) {
                return gift;
            }
        }

        return  0;

    }*/
}
