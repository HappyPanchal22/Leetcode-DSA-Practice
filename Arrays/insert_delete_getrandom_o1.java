/**
 * 380. Insert Delete GetRandom O(1)
 * Difficulty: Medium
 * 
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n)
 * 
 * Tags: Array, Hash Table, Design, Randomized
 */

class RandomizedSet {
    private Map<Integer, Integer> map;      // value → index in list
    private List<Integer> list;             // stores actual values
    private Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        // If already exists, return false
        if(map.containsKey(val)){
            return false;
        }
        // Add to end of list
        list.add(val);
        
        // Store: value → its index (which is list.size() - 1)
        map.put(val,list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        //Get the index of element to remove
        int indextoremove = map.get(val);
        //Get the last element in list
        int lastElement = list.get(list.size() - 1);
        //SWAP! Put last element at position of element to remove
        list.set(indextoremove,lastElement);
        //Update HashMap for the moved element
        // (lastElement moved from end to indexToRemove)
        map.put(lastElement, indextoremove);

        //Remove last element from list (O(1)!)
        list.remove(list.size() - 1);

        //Remove the deleted value from HashMap
        map.remove(val);

        return true;

    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());

        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
