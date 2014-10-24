package problems;

public class passByValue
{
	public void swap(String x, String y)
	{
		String temp = x;
		x=y;
		y=temp;
	}
	public static void main(String args[])
	{
		String xx = new String("Mohamed");
		String yy = new String("Ibrahim");
		passByValue t0= new passByValue();
		System.out.println("The value of x and y before swap are "+xx+", "+yy);
		t0.swap(xx,yy);
		System.out.println("The value of x and y after swap are "+xx+", "+yy);
	}
}