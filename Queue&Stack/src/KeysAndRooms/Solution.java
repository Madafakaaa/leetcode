package KeysAndRooms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomsNum = rooms.size();
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int currRoom = queue.poll();
            for (Integer k : rooms.get(currRoom)) {
                if (set.contains(k)) continue;
                set.add(k);
                queue.add(k);
            }
        }
        if (set.size() == roomsNum) return true;
        return false;
    }
}