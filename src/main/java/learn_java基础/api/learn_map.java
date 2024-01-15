package learn_java基础.api;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class learn_map {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put(null, "c");

        // 1.1 遍历map
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        //1.2 遍历map
        for(String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
        //1.3 遍历map
        map.forEach((key,value)->{
            System.out.println(key + " " + value);
        });
        // 2. 遍历key
        for(String key : map.keySet()){
            System.out.println(key);
        }
    }
}
