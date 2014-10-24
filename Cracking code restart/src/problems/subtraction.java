package problems;

public class subtraction {
	public static int divide(int dividend, int divisor) {
        int flag = 0;
        int flag1 = 0;
        int flag2 = 0;
        
		if (dividend < 0){
			dividend = -dividend;
			flag = 1;
		}
		if (divisor < 0){
			divisor = -divisor;
			flag1 = 1;
		}
		if (dividend < divisor) return 0;
		int ans = 0;
		while (dividend >= divisor){
			dividend -=divisor;
			ans++;
		}
		if (flag == 1 && flag1 == 1)
			return ans;
		if (flag != 1 && flag1 == 1)
			return -ans;
		if (flag == 1 && flag1 != 1)
			return -ans;
		return ans;
		
		
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2147483647;
		int b = 1;
		
		System.out.println(divide(a,b));
		System.out.println(a/b);
	}

}
