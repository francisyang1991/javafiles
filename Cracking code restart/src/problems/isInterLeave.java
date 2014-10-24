package problems;

public class isInterLeave {

	
	public static boolean isInterleave(String s1, String s2, String s3,int i1,int i2,int i3){
		char c1,c2 = 0,c3 = 0;
		
		
		if (i3 == s3.length())
			return true;
		else c3 = s3.charAt(i3);
			
			
		if (i1 == s1.length())
			if (i1>0)
			return isInterleave(s1,s2,s3,i1,++i2,++i3);
			else return false;
		if (i2 == s2.length())
			if (i2>0)
			return isInterleave(s1,s2,s3,++i1,i2,++i3);
			else return false;
		if (i1 <s1.length())
		  c1 = s1.charAt(i1);
		else  c1 = ' ';
		
		if (i2 <s2.length())
			  c2 = s2.charAt(i2);
			else  c1 = ' ';
		
      
         while (c1 != c2 && (c1==c3 || c2 ==c3)){
        	 if (c1 == c3 && c2 != c3){
        		 i1++;
             if (i1 == s1.length())
     			return isInterleave(s1,s2,s3,i1,++i2,++i3);
             i3++; 
             if (i3 == s3.length())
     			return true;
             c1 = s1.charAt(i1);
             c3 = s3.charAt(i3);
        	 }
        	 if (c1 != c3 && c2 == c3){
                 i2++;
                 if (i2 == s2.length())
         			return isInterleave(s1,s2,s3,++i1,i2,++i3);
                 i3++; 
                 if (i3 == s3.length())
         			return true;
                 c2 = s2.charAt(i2);
                 c3 = s3.charAt(i3);
           	 }
         }
         if (c1 != c3) return false;
         else {
         return isInterleave(s1,s2,s3,++i1,i2,++i3)||isInterleave(s1,s2,s3,i1,++i2,++i3);
         }
		
		
	}	
	
	public static boolean isInterleave(String s1, String s2, String s3){
		

		int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        
        return isInterleave(s1,s2,s3,0,0,0);
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		String s4 = "aadbbbaccc";
		
		String s5 = "b";
		String s6 = "";
		String s7 = "b";
		
		System.out.println(isInterleave(s5,s6,s7));
    
           
	}

}
