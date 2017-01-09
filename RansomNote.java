import java.util.*;

public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> mag = new HashMap<String, Integer>();
        
        int m = in.nextInt();
        int n = in.nextInt();
        String key;
        //String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            key = in.next();
            mag.put(key, mag.getOrDefault(key, 0)+1);
        }
        
        //String ransom[] = new String[n];
        boolean allFound = true;
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            key = in.next();
            if(mag.containsKey(key) && mag.get(key)>0){
            	mag.put(key, mag.get(key)-1);
            }
            else{
            	allFound = false;
            	break;
            }
        }
        in.close();
        if(allFound)
        	System.out.println("Yes");
        else
        	System.out.println("No");
    }
}
