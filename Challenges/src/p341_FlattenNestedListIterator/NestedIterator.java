package p341_FlattenNestedListIterator;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/8/20 11:34
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    public List<Integer> list;
    public int currentIndex;

    public NestedIterator(List<NestedInteger> nestedList) {
        currentIndex = 0;
        list = new ArrayList<Integer>();
        init(nestedList);
    }

    public void init(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                this.list.add(nestedInteger.getInteger());
            } else {
                init(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (this.hasNext()) {
            Integer res = list.get(currentIndex);
            this.currentIndex++;
            return res;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex < this.list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
