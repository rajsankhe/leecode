/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> temp_list = new ArrayList<>();
    int i = 0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flatList(nestedList);
    }
    
    private void flatList(List<NestedInteger> nestedList){
        for(NestedInteger nestedInteger : nestedList){
            if (nestedInteger.isInteger()){
                temp_list.add(nestedInteger.getInteger());
            } else {
                flatList(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return temp_list.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i != temp_list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */