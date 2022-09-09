package ss11_slack_queue.bai_tap.stack_treemap;

import java.util.Map;
import java.util.TreeMap;

public class CountCharacter {
    public static void main(String[] args) {
        String str = "Hello motorola Tama";
        Map<Character, Integer> map = new TreeMap<>();

        for(char c: str.toLowerCase().toCharArray()) {
            if(c == ' ') continue;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            System.out.printf("char : %c, numbers: %d\n", entry.getKey(), entry.getValue());
        }
    }
}