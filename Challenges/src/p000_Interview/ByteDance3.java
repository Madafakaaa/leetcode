package p000_Interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/29 16:04
 */
public class ByteDance3 {

    public static void main(String[] args) {
        ArrayList<Obj> list = new ArrayList<Obj>(6);
        Set<Obj> set = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            list.add(new Obj(i));
            set.add(list.get(i - 1));
        }
        list.get(0).refs.add(list.get(2));
        list.get(2).refs.add(list.get(3));
        list.get(3).refs.add(list.get(4));
        list.get(4).refs.add(list.get(2));
        list.get(1).refs.add(list.get(2));
        list.get(2).refs.add(list.get(1));
        list.get(1).refs.add(list.get(5));
        list.get(5).refs.add(list.get(4));
        Set<Set<Obj>> res = computeCycle(set);
        for (Set<Obj> s : res) {
            for (Obj o : s) {
                System.out.print(o.id);
            }
            System.out.println();
        }
    }

    public static Set<Set<Obj>> computeCycle(Set<Obj> objs) {
        Set<Obj> seen = new HashSet<>();
        Set<Set<Obj>> res = new HashSet<Set<Obj>>();
        for (Obj obj : objs) {
            dfs(res, seen, obj, obj);
        }
        return res;
    }

    public static void dfs(Set<Set<Obj>> res, Set<Obj> seen, Obj obj, Obj target) {
        if (obj == target && !seen.isEmpty()) {
            res.add(new HashSet(seen));
            return;
        }
        if (seen.contains(obj)) {
            return;
        }
        seen.add(obj);
        for (Obj sub : obj.refs) {
            dfs(res, seen, sub, target);
        }
        seen.remove(obj);
    }

    public static class Obj {
        int id;
        Set<Obj> refs;

        public Obj(int id) {
            this.id = id;
            this.refs = new HashSet<Obj>();
        }
    }

}
