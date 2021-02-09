package p017_LetterCombinationsOfPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> dict = new HashMap<>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        result.add("");
        for(int i=0;i<digits.length();i++){
            List<String> temp = new ArrayList<>();
            for(int j=0;j<result.size();j++){
                for(int k=0;k<dict.get(digits.charAt(i)).length();k++){
                    StringBuffer sb = new StringBuffer(result.get(j));
                    sb.append(dict.get(digits.charAt(i)).charAt(k));
                    temp.add(sb.toString());
                }
            }
            result = temp;
        }
        return result;
    }

}
