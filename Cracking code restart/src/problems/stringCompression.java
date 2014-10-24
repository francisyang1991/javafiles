package problems;


public class stringCompression {

	
	public static String strCompression(String str){
		String newString = "";
		
		//predict the length of newString after compression
		 int size = countForCompression(str);
		 if (size >= str.length())
			 return str;
		 
		 StringBuffer sb = new StringBuffer();
		 
		 int count = 1;
		 char last;
		 last = str.charAt(0);
		 for(int i = 1;i<str.length();i++){
			 if (last == str.charAt(i)){
				 count++;
			 }
			 else {
				
				 sb.append(last);
				 sb.append(String.valueOf(count));
				 System.out.println("the last is " + last+ "     the count is " + count);
				 //
				 last = str.charAt(i);
				 count = 1;
			 }
		 }
		 sb.append(last);
		 sb.append(String.valueOf(count));
		 
		 newString = sb.toString();
		
		return newString;
	}
	
	
	public static int countForCompression(String str){
		int len = str.length();
		int count = 0;
		int sum = 0;
		char last;
		last = str.charAt(0);
		count++;
		for(int i = 1;i<len;i++){
			if (last == str.charAt(i)){
				count++;
			}
			else {
				last = str.charAt(i);			
				sum += String.valueOf(count).length() + 1;
				count = 1;
			}
			
		}
		
		sum += String.valueOf(count).length() + 1;
	
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "aabcccccaaa";
		
		System.out.println(strCompression(str));
		
		
		
	}

}
