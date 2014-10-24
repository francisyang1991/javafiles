package apactest;

import java.math.BigInteger;

public class selfPara {

	
	static String catlan(int n,BigInteger k){
		
		int N = 105;
	    BigInteger c[][] = new BigInteger[N][N];
	    BigInteger fac[] = new BigInteger [N * 2];	
		
	    for (int i = 1 ; i < N ; i ++) {
            c[i][0] = BigInteger.ONE;
            for (int j = 1 ; j <= i ; j ++) {
                if (i == j)
                	c[i][j] = c[i][j-1];
                else {
                	c[i][j] = c[i][j-1].add(c[i-1][j]);
                	
                }
            }
        }
	    
	    StringBuffer ans =  new StringBuffer();
	    int left = n;
	    int right = n;
	    
	    
	    if (c[n][n].compareTo(k) < 0) {
            System.out.println("Doesn't Exist!");
           
        }
	    
	    for (int i = 0; i< 2*n;i++){
	    	
	    	if (left > 0){
	    		if (c[right][left-1].compareTo(k) >= 0){
	    			left--;
	    			ans.append("(");
	    			continue;
	    		}	
	    		System.out.println(k);
	    		k = k.subtract(c[right][left-1]);
	    		
	    	}
	    	ans.append(")");
	    	right--;
	    }
	
	    print2Array(c,n+1,n+1);
	    
	    return ans.toString();
	}
	
	
	
	
	
static void print2Array(BigInteger[][] arr,int l,int h){
		
		int m = l;
		int n = h;
		
		for (int i = 0;i< m;i++){
			
			for (int j = 0;j<n;j++){
				
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String kb = "2";
		BigInteger k = new BigInteger(kb);
		
		System.out.println(catlan(4,k));
		
		
		
	}

}
