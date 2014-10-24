package problems;

import java.util.Stack;

public class solveRpn {


	public static int evalRPN(String[] tokens) {
		int len = tokens.length;
		Stack<Integer> st = new Stack<Integer>();

		if (len == 1) return Integer.parseInt(tokens[0]);

		
		else if (len >=3){
			st.push(Integer.parseInt(tokens[0]));
			st.push(Integer.parseInt(tokens[1]));
			int  i = 2;
			while (!st.isEmpty() && i<tokens.length){
				if (tokens[i].length()<2) {
					if (tokens[i].charAt(0) < '0' ||tokens[i].charAt(0)>'9'){

						int first  = st.pop();
						int second = st.pop();
						int ans = 0;
						if (tokens[i].charAt(0) == '+'){
							ans = second + first;
						}
						if (tokens[i].charAt(0) == '-'){
							ans = second - first;
						}
						if (tokens[i].charAt(0) == '*'){
							ans = second * first;
						}
						if (tokens[i].charAt(0) == '/'){
							ans = second / first;
						}

						st.push(ans);

					}
					else {
						st.push(Integer.parseInt(tokens[i]));
					}
				}

					else {
						st.push(Integer.parseInt(tokens[i]));
					}

				i++;

			}

			return st.pop();
		}

		return Integer.MAX_VALUE;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] str = {"2","1","+","3","*"};

		System.out.println(evalRPN(str));


	}

}
