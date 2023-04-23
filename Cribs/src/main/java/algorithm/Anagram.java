package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public boolean checkStrings(String first, String second) {
        Map<String, Integer> firstMap = getStringMap(first);
        Map<String, Integer> secondMap = getStringMap(second);

        return firstMap.equals(secondMap);
    }

    private Map<String, Integer> getStringMap(final String string) {
        Map<String, Integer> map = new HashMap<>();
        for (final char nextChar : string.toLowerCase().toCharArray()) {
            map.merge(String.valueOf(nextChar), 1, Integer::sum);
        }
        return map;
    }

}
