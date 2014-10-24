package problems;

import java.util.HashMap;
import java.util.HashSet;

public class findAllSubPalinDrome {

	
	public static void finaSubPal(String str){
		
		int length = str.length();
		HashMap<String,Integer> hs = new HashMap<String,Integer>();
		String s1 = "";
		
		for (int i = 0;i<length;i++){
			for (int j = i+2;j<length;j++){
				
//			int k = i+j+1;
//			if (k>length){
//				continue;
//				
//			}
			
			s1 = str.substring(i,j+1);
			if (s1.equals(new StringBuffer(s1).reverse().toString()) && s1.length()>2)
				hs.put(s1, i);
			}
		}
		
		
		System.out.println(hs.toString());
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test1= "abcacbbbca";
		finaSubPal(test1);
		
	}

}
