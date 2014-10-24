package problems;

class doubleToString {

	
	public static String d2s(double dd){
		StringBuffer front =  new StringBuffer();
		StringBuffer rear  = new StringBuffer();
		
		double frac = dd-(int)dd;
		int intd = (int) (dd - frac);
		
		while (intd > 0){
			int k = intd % 10;
			front.append(k);
			intd /=10;
		}
		
		while (frac > 0.001){
			frac *=10;
			rear.append((int)frac);
			frac = frac - (int)frac;	
		}
		
		return front.reverse().toString()+"."+rear.toString();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(d2s(11113.33333));
		
		
		
	}

}
