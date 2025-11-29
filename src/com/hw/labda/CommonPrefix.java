package com.hw.labda;

import java.util.Arrays;

public class CommonPrefix {

    public static String longestCommonPrefix(String[] words) {
        String ans="";
        int lastMax=0;
        String current ="";
        String [] firstWord = words[0].split("");
        for (int i = 0; i <firstWord.length ; i++) {
            current+=firstWord[i];
            String loopCurr = current;
           if(Arrays.stream(words)
                   .allMatch(e->e.contains(loopCurr))&&current.length()>ans.length()){
               ans=current;
           }
           else {
               current=null;
               break;
           }

        }

       // return ans;
      return ans.length()>0?ans:"''";
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }


}