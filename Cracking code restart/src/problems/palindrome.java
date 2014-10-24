package problems;

public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 1;
		int i = x;
		int ans = 0;
		while (x!=0){
			int xx = x % 10;
			ans = ans*10 +xx;
			x = x /10;		
		}
		
		if (ans == i)		
			System.out.println("true");
		else System.out.println("false");
	}

}
