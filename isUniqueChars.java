package arraysandstrings;

import java.util.Arrays;

public class isUniqueChars {

	//checks for uniqueness in O(nlogn) without extra space
	public static boolean isUnique(String s){
		boolean isUni = true;
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		for(int i=0; i<(chars.length - 1); i++  ){
			if(chars[i]==chars[i+1]){
				isUni = false;
				break;
			}
		}
		return isUni;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "BRENDO";
		System.out.println(isUnique(s));
	}

}
