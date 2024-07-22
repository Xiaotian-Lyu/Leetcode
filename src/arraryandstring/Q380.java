package arraryandstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Q380 {
    class RandomizedSet {
        //attribute: ArrayList Hashmap Random
        private ArrayList<Integer> list;
        private HashMap<Integer,Integer> map;
        private Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            //check if contains val
            if(map.containsKey(val)){
                return false;
            }
            //insert
            list.add(val);
            int index = list.size() - 1;
            map.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            //get the remove index
            int removeIndex = map.get(val);
            //get the last element
            int lastElement = list.get(list.size() - 1);
            //change palce in the list
            list.set(removeIndex, lastElement);
            //add to the map
            map.put(lastElement, removeIndex);
            //remove from the list
            list.remove(list.size() - 1);
            //remove val from map
            map.remove(val);

            return true;
        }

        public int getRandom() {
            int randomIndex = random.nextInt(list.size()); //左必右开区间list.size()- 1
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
}
