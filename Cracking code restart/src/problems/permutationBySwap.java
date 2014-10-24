package problems;

import java.util.Arrays;

/**
 * Created by xiaodongyang on 10/21/14.
 */
public class permutationBySwap {



    public static String nextPermutation(String s){

        int len = s.length();
        if (len == 1) return s;
        StringBuffer sb = new StringBuffer(s);
        int k = len-1;
        while (k>=1 && s.charAt(k)<s.charAt(k-1)){
            k--;
        }
        if (k == 0) return new StringBuffer(s).reverse().toString();

        k--;
        int l = k+1;
        while (l<len && s.charAt(k)<s.charAt(l)){
            ++l;
        }
        l--;
        char tmp = sb.charAt(k);
        sb.setCharAt(k, sb.charAt(l));
        sb.setCharAt(l,tmp);
        char[] carr = sb.substring(k+1).toCharArray();
        Arrays.sort(carr);
        String sorted = new String(carr);

        sb.replace(k+1,len,sorted);

        return sb.toString();

    }


    public static void main(String[] args){

        String str = "511";
        int ans = 0;
        String output;
//        do{
//             output = nextPermutation(str);
//
//            ans = Integer.parseInt(output);
//
//            if (ans % 2 == 0 ) break;
//            else str = output;
//
//
//        } while ( !output.equals("0"));


        output = nextPermutation(str);
        ans = Integer.parseInt(output);
        System.out.println(ans);

    }
}
