package problems;

/**
 * Created by xiaodongyang on 10/21/14.
 */
public class PalindromePartionMinCut {


    public static int solve(String str){

        int len = str.length();

        if (len == 0 || len == 1) return 0;

        int[] f = new int[len+1];

        boolean[][] isPalin = new boolean[len][len];

        for (int i = 0;i<len;++i){
            f[i] = len - i;
        }

        for (int i = len-1;i>=0;--i){
            for (int j = i;j<len;++j){

                if ((str.charAt(i) == str.charAt(j) && j-i<2) || (str.charAt(i)== str.charAt(j) && isPalin[i+1][j-1])){
                    isPalin[i][j] = true;
                    f[i] = Math.min(f[i],f[j+1]+1);
                }
            }
        }

        return f[0]-1;


    }


    public static void main(String[] args){


        String s = "abbacaca";


        System.out.println("The min cut is "+solve(s));


    }


}
