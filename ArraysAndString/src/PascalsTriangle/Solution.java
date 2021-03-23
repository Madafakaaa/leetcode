package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 0; i < numRows; i++) {
            result.add(row);
            row = getNextRow(row);
        }
        return result;
    }

    public ArrayList<Integer> getNextRow(List<Integer> row) {
        ArrayList<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        for (int i = 1; i < row.size(); i++) {
            newRow.add(row.get(i - 1) + row.get(i));
        }
        newRow.add(1);
        return newRow;
    }
}