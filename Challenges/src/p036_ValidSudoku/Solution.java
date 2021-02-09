package p036_ValidSudoku;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, ArrayList<Integer>> row = new HashMap<>();
        HashMap<Character, ArrayList<Integer>> column = new HashMap<>();
        HashMap<Integer, ArrayList<Character>> box = new HashMap<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                Character temp = board[i][j];
                if(temp!='.'){
                    row.putIfAbsent(temp, new ArrayList<Integer>());
                    if(row.get(temp).contains(i)){
                        return false;
                    }
                    column.putIfAbsent(temp, new ArrayList<Integer>());
                    if(column.get(temp).contains(j)){
                        return false;
                    }
                    Integer boxId = (i/3)*3+(j/3);
                    box.putIfAbsent(boxId, new ArrayList<Character>());
                    if(box.get(boxId).contains(temp)){
                        return false;
                    }
                    row.get(temp).add(i);
                    column.get(temp).add(j);
                    box.get(boxId).add(temp);
                }
            }
        }
        return true;
    }

}