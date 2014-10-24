package problems;

public class addBinary {

public static String addBinary(String a, String b) {
        
        StringBuffer sb = new StringBuffer();
        int alen = a.length();
        int blen = b.length();
        int c = 0;
        
        
        if (alen>blen){
        	String str = "";
        	for (int i = 0;i<alen-blen;i++){
        		str +="0"; 
        	}
        	b = str+b;
        }
        if (alen<blen){
        	String str = "";
        	for (int i = 0;i<blen-alen;i++){
        		str +="0"; 
        	}
        	a = str+a;
        }
        
        int len = a.length();
        for (int i = len-1;i>=0;i--){
            int ai = (int)(a.charAt(i)-'0');
            int bi = (int)(b.charAt(i)-'0');
            int k = (ai+bi+c)%2;
            c = (ai+bi+c) / 2;      
            sb.append(Integer.toString(k));
        }
        if (c != 0)
        	sb.append(Integer.toString(c));
        
        
        
        return sb.reverse().toString();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "11";
		String str2 = "1";
		
		System.out.println(addBinary(str1,str2));
		
	}

}
