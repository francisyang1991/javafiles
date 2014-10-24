package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class textJustification {

	
public static ArrayList<Integer> makeLine(ArrayList<Integer> singleLine, int temp,int length){
	
	if (length == 0){
		return singleLine;
	}
	if (temp % length != 0){
		int x = temp / length + 1;
		temp = temp - x;
		singleLine.add(x);		
	}
	else {
		for (int i = 0; i< length;i++){
			singleLine.add(temp / length);
			return singleLine;
		}
	}
	return makeLine(singleLine,temp,length-1);
	
}
	
 
public static ArrayList<String> fullJustify(String[] words, int L) {
	
	ArrayList<String> out = new ArrayList<String>();
	ArrayList<ArrayList<String>> wordsWithLines = new ArrayList<ArrayList<String>>();
	
	int[] lengthOfWord  = new int[words.length];
	
	int j  = 0;
	for (String s:words){
		lengthOfWord[j] = s.length();
		j++;
		//System.out.print("  "+s.length())
	}
	
	int temp = 0;
	int min  = 0;
	ArrayList<String> singleLine = new ArrayList<String>();
	for (int i = 0;i<lengthOfWord.length;i++){
		if (i == 0) {
			temp  = lengthOfWord[0];
			if (temp <= L)
				singleLine.add(words[0]);
			continue;
		}
		temp = temp + lengthOfWord[i];
		min  = temp + singleLine.size();
		
		if (min > L){
			temp = temp - lengthOfWord[i];
			
			temp = L - temp;
			if (temp == 0){
				out.add(singleLine.get(0));
				singleLine.clear();
				min = 0;
				
			}
			System.out.println("It have " + temp + " spaces to split");
			wordsWithLines.add(singleLine);
			
			if (temp % (singleLine.size()-1) == 0){
				int spaceNumber = temp/(singleLine.size()-1);
				char[] space = new char[spaceNumber];
				Arrays.fill(space, ' ');
				StringBuffer line = new StringBuffer(L);
				int lengthOfSingleLine = singleLine.size();
				for (int k = 0;k<lengthOfSingleLine-1;k++){
													
					line.append(singleLine.get(k));
					line.append(space);				
					
				}
				line.append(singleLine.get(lengthOfSingleLine-1));
				
				out.add(line.toString());
			}
			else {
				
				ArrayList<Integer> spaceNumber  = new ArrayList<Integer>();
				int lengthOfSingleLine = singleLine.size();
				spaceNumber = makeLine(spaceNumber,temp,lengthOfSingleLine-1);
				
				StringBuffer line = new StringBuffer(L);			
				for (int k = 0;k<lengthOfSingleLine-1;k++){
									
					line.append(singleLine.get(k));					
					char[] space = new char[spaceNumber.get(k)];
					Arrays.fill(space, ' ');
					line.append(space);
				}
				line.append(singleLine.get(lengthOfSingleLine-1));
				out.add(line.toString());
				
			}
					
			
			singleLine.clear();
			singleLine.add(words[i]);
			temp = lengthOfWord[i];
			min  = temp + singleLine.size();
		}
		else {
			singleLine.add(words[i]);
		}
			
		
	}
	
	char[] space = new char[L-temp];
	StringBuffer line = new StringBuffer(L);

	line.append(singleLine.get(0));
	Arrays.fill(space, ' ');
	line.append(space);
	
    out.add(line.toString());   
        
      return out;
   }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] str1 = {"a","b","c","d","e"};
		String[] str2 = {"Listen","to","many,","speak","to","a","few."};
		int L = 16;
	
		
		ArrayList<String> answer = new ArrayList<String>();
		
		answer = fullJustify(str2,6);
		System.out.println(answer);
		
		
		
	}

}
