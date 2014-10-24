package problems;

public class removeDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {1,1,1,2,2,3,3,3};
		int len = A.length;
        int current = A[0];
        int pos = 1;
        for (int i = 1;i<A.length ;i++){
            if (current == A[i]){
                len--;
            }
            else {
                current = A[i];
                A[pos]  = A[i];
                pos++;
            }
            
        }
        
        
	}

}
