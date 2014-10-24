package apactest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;


class item {

	String Id;
	String name;
	double value;
	int num;

	item(String Id,String name,double value,int num){
		this.Id = Id;
		this.name = name;
		this.value = value;
		this.num = num;
	}
}

class change{

	String slot;
	double value;
	int num;

	change(String slot,double value,int num){

		this.slot = slot;
		this.value = value;
		this.num = num;
	}


}




public class a {


	public static long solve(int m, int n){

		return 0;
	}

	static void print2Array(long[][] arr,int l,int h){

		int m = l;
		int n = h;

		for (int i = 0;i< m;i++){

			for (int j = 0;j<n;j++){

				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}



	}

	public static long factorial(int n) {
		long fact = 1; // this  will be the result
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputfilename = "A-small-attempt0.in-2.txt";
		String output = "output.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));


		int number = 0;

		String line = "";


		ArrayList<item> itemlist = new ArrayList<item>();
		ArrayList<change> changelist = new ArrayList<change>();
		//ArrayList<String[]> list = new ArrayList<String[]>();
		HashMap<String,Double> hs = new HashMap<String,Double>();
		ArrayList<String[]> acts = new ArrayList<String[]>();
	while((line=br.readLine())!=null && line.length()!=0){

			String[] strlist = line.split(",");

			if (strlist[0].equals("Actions")){
				StringBuffer  sb = new StringBuffer();

				double total;
				double money = 0;
				boolean flag1 = false;
				boolean flag2 = false;
				double value = 0;
				for (int i = 1;i<strlist.length;i++){

					

					String act = strlist[i];

					if (act.charAt(0)>='A' && act.charAt(0)<='Z'){
						sb.append(act);
					}
					if (act.charAt(0) >= '0' && act.charAt(0)<='9'){
						sb.append(act);
						
					}
					if (act.charAt(0) == '$'){
						 value = Double.parseDouble(act.substring(1));
					
					}
					
					if (flag1 && flag2){
						String[] s = new String[2];
						
						s[0] = sb.toString();
						s[1] = Double.toString(value);						
						acts.add(s);
					}
			
				}					
			}
			else if (strlist[0].charAt(0) >= 'A' && strlist[0].charAt(0)<='Z'){

				String Id = strlist[0];
				String name = strlist[1];
				double value = Double.parseDouble(strlist[2]);
				int num = Integer.parseInt(strlist[3]);

				item ite = new item(Id,name,value,num);
				itemlist.add(ite);

			}
			else if (strlist[0].charAt(0) >= '$'){


				String slot = strlist[0];
				int num = Integer.parseInt(strlist[1]);
				double value = Double.parseDouble(strlist[2]);
				change ch = new change(slot,value,num);
				changelist.add(ch);

			}			
		}


		for (int i =0;i<acts.size();i++){
			
			String id = acts.get(i)[0];
			double value = Double.parseDouble(acts.get(i)[1]);
			
			
			double remain = 0;
				for (int j = 0;j<itemlist.size();j++){
					item newitem = itemlist.get(j);
					if (newitem.Id.equals(id) && newitem.num>0){
						remain = value-newitem.value;
						newitem.num--;
					}
				}

				double re = remain;
				double[] slots = new double[changelist.size()];
				int[] slotInt = new int[changelist.size()];

				for (int j = changelist.size()-1;j>=0;j--){
					change newchange = changelist.get(j);
					if (re > 0 && newchange.num>0){
						slots[j] = re/newchange.value;
						slotInt[j] = (int) Math.floor(slots[j]);
						re = re - slotInt[j]*newchange.value;
						newchange.num -=slotInt[j];
					}
				}

			}
		
		
		
		for (int i = 0;i<itemlist.size();i++){
			item ii = itemlist.get(i);
			System.out.println(ii.Id+","+ii.name+","+ii.num);
			System.out.println();	
		}
		double sum = 0;
		for (int i = 0 ;i<changelist.size();i++){
			change cc = changelist.get(i);
			
			System.out.println(cc.slot+","+cc.num);
			sum = cc.value*cc.num+sum;
			System.out.println();
		}
		
		
		System.out.println("$$"+sum);

		
		
		
		
		bw.close();
	}

}

