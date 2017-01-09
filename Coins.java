package dynamicprog;

import java.util.*;

public class Coins {

    public static long[] combos;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        combos = new long[n+1];
        combos[0] = 1;
        System.out.println(GetCombo(n, coins));
        in.close();
    }
    
    public static long GetCombo(int n, int[] coins){
        for(int i = 0; i< coins.length; i++){
            for(int j=coins[i]; j<combos.length ; j++){
                combos[j] += combos[j - coins[i]];
            }
        }
        return combos[n];
    }
}

