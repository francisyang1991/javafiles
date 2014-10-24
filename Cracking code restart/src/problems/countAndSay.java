package problems;

public class countAndSay {

	
	public static String helper(String str){
		StringBuffer sb  = new StringBuffer();
		char c;
		int count = 1;
		//char prev;
		
		c = str.charAt(0);
		for (int i = 1;i<str.length();i++){
			char cc = str.charAt(i);
			if (cc == c){
				count++;
				continue;			
			}
			else {
				sb.append(count);
				sb.append(c);
				count =1;
				c = cc;			
			}
			
		}
		sb.append(count);
		sb.append(c);
		
		return sb.toString();
		
	}
	
	
	public static String countAndSay(int n) {
        
		String prev = "1";
		String x = prev;
		for (int i = 0;i<n-1;i++){
			
			x = helper(prev);
			
			prev = x;
		}
		
		return x;
		
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println(countAndSay(5));
		
	}

}
