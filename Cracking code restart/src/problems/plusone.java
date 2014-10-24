package problems;

public class plusone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] digits = {9,9,9,9,9};
		int size = 0;
		boolean equal = false;
		int len = digits.length;
		int sum = 0;
		for(int i = 0; i<len;i++){
			if (digits[i] == 9)
				sum++;
		}
		if (sum == digits.length){
			size = len+1;
		}
		else {
			size = len;
			equal = true;
		}
        
        int[] num = new int[size];
        int flag = 0;
        int s = 0;
        
        if (equal){
            s = (digits[len-1] + 1) / 10;
            num[len-1] = (digits[len-1] + 1) % 10;
            flag = s;
            for (int i = digits.length-2;i >= 0;i--){
                s = (digits[i] + flag) / 10;
                num[i] = (digits[i]+ flag) % 10;
                flag = s;
            } 

        }
        else {
             s = (digits[len-1] + 1) / 10;
            num[len] = (digits[len-1] + 1) % 10;
            flag = s;
            for (int i = digits.length-2;i >= 0;i--){
                s = (digits[i] + flag) / 10;
                num[i+1] = (digits[i]+ flag) % 10;
                flag = s;
            }
            
            num[0] = 1;
        }
        for (int i =0;i<num.length;i++)
        	System.out.print(num[i]);
	}

}
