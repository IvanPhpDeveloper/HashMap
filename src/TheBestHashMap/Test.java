package TheBestHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1,  "A");
        map.put(2,  "B");
        map.put(3,  "C");

        String value = map.get(2);

        System.out.println("The value is :: "+  value );

        System.out.println("Size of map is:- "
                + map.size());
        System.out.println(map);

        map.remove(3);
        System.out.println(map);

        Iterator<Integer> itr = map.keySet().iterator();

        while (itr.hasNext())
        {
            Integer key = itr.next();
            value = map.get(key);

            System.out.println("The key is :: " + key + ", and value is :: " + value );
        }
        Iterator<Map.Entry<Integer, String>> entryIterator = map.entrySet().iterator();

        while (entryIterator.hasNext())
        {
            Map.Entry<Integer, String> entry = entryIterator.next();

            System.out.println("The key is :: " + entry.getKey() + ", and value is :: " + entry.getValue() );
        }


    }
}