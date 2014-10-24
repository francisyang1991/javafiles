package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Info{
    String str;
    int length;
    
    Info(String str){
        this.str = str;
        this.length = str.length();
    }
    
}

public class MinimumWindowSubstring {

static public String minWindow(String S, String T) {
        
        HashMap<Character,Integer> hsHave = new HashMap<Character,Integer>();
        //HashMap<Character,Integer> hsNeed = new HashMap<Character,Integer>();
        List<Info> infolist = new ArrayList<Info>();
        int lenS = S.length();
        int lenT = T.length();
        
        if (lenT > lenS || lenS == 0) return "";
        if (lenT == 0 ) return "";
        int need = lenT;
        int start = 0;
        for (int i=0;i<lenT;i++){
            char c = T.charAt(i);
            hsHave.put(c,(hsHave.containsKey(c)?(hsHave.get(c)-1):-1));
            
        }
        

        for (int i=0;i<lenS;i++){
            
            char tmpC = S.charAt(i);
            
            if (need > 0){
                
                if (hsHave.containsKey(tmpC)){
                    int have = hsHave.get(tmpC);
                    if (have < 0) {
                        need--;
                        hsHave.put(tmpC,have+1);
                    }
                    else {
                        hsHave.put(tmpC,have+1);
                    }
                }
                continue;
            }
            else{
            	while(!hsHave.containsKey(S.charAt(start)) || hsHave.get(S.charAt(start)) > 0){
            		char tmp = S.charAt(start);
            		if (hsHave.containsKey(tmp) && hsHave.get(tmp) > 0){
            			hsHave.put(tmp,hsHave.get(tmp)-1);
            		}         		
                    start++;
                }    	
                Info info= new Info(S.substring(start,i));
                infolist.add(info);              
                need++;
                char tmp = S.charAt(start);
                hsHave.put(tmp,hsHave.get(tmp)-1);
                start++;
            }
        }
        if (need == 0){
	        while(!hsHave.containsKey(S.charAt(start)) || hsHave.get(S.charAt(start)) > 0){
	    		char tmp = S.charAt(start);
	    		if (hsHave.containsKey(tmp) && hsHave.get(tmp) > 0){
	    			hsHave.put(tmp,hsHave.get(tmp)-1);
	    		}         		
	            start++;
	        }    	
	        Info info= new Info(S.substring(start,lenS));
	        infolist.add(info);                 
        }
        else {
        	return "";
        }
        
        int min = lenS;
        String ans ="";
        for (Info iff:infolist)
        {
        	if (iff.length<min){
        		min = iff.length;
        		ans = iff.str;
        	}
        }
        
        
        return ans;
        
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		String S  = "ADOBECODEBANC";
		String T  = "ABC";
		
		System.out.println(minWindow(S,T));
		
		
		
	}

}
