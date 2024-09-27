package bbg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class lotterySystem {
    class User{
        int id;
        public User(int id){
            this.id = id;
        }
    }

    HashMap<Integer, User> map = new HashMap<>();
    HashMap<Integer, Integer> mapIndex = new HashMap<>();//id, index
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    //default constructor

    public void add(int id){
        User user = new User(id);
        map.put(id, user);
        list.add(id);
        mapIndex.put(id, list.size()-1);//index？？
    }

    public User randomPick(){
        int index = random.nextInt(list.size());
        int id = list.get(index);
        //remove the user
        int needTODeleteId = list.get(list.size()-1);
        if (index != list.size()-1){
            int lastId = list.get(list.size()-1);
            list.set(index, lastId);
            mapIndex.put(lastId, index);
        }
        map.remove(needTODeleteId);
        mapIndex.remove(needTODeleteId);
        list.remove(list.size()-1);
        return map.get(id);
    }
}
