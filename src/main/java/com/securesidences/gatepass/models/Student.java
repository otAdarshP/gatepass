package com.securesidences.gatepass.models;
import java.util.HashMap;

public class Student {
        public boolean isAnagram (String s, String t){
            if (s.length () != t.length()){
                return false;
            }
            int [] count = new int [26];
            for (int i = 0; i < s.length(); i++){

                count [s.charAt(i) - 'a']++;
                count [t.charAt(i) - 'a']--;
            }
            for (int value : count){
                if (value != 0){
                    return false;
                }
            }
            return true;
    }
}

// this is a leetcode question's solution.

