package problems;

public class lastwordlength {
	
	
	
	public static int lengthOfLastWord(String s) {
		
		int len = s.length();
		
		String[] words = s.split(" ");
		
		if (words.length == 0)
			return 0;
		
		
		for (int i =0;i<words.length;i++)
		System.out.println(words[i]);
	
		return words[words.length-1].length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Hello world";
		String s = " ";
		
		System.out.print(lengthOfLastWord(s));
		
		
	}

}
