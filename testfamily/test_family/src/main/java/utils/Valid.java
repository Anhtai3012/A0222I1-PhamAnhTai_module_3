package utils;

import models.HouseHold;

import java.util.HashMap;
import java.util.Map;

public class Valid {

    public static Map<String, String> checkValid(HouseHold houseHold) {
        String nameRegex = "^[a-zA-Z]+[ a-zA-Z]*$";
        Map<String, String> map = new HashMap<>();
        checkEmpty(houseHold.getAddress(), map, "address");
        checkName(houseHold.getName(), nameRegex, map, "name");
        return map;
    }


    public static void checkName(String target, String regex, Map<String, String> map, String key) {
        if (target.trim().isEmpty()) {
            map.put(key, "input something not null");
            return;
        }

        if (!target.matches(regex)) {
            map.put(key, "Not Match Regex");
        }
    }

    public static void checkEmpty(String target, Map<String, String> map, String key) {
        if (target.trim().isEmpty()) {
            map.put(key, "input something not null");
        }
    }
}
