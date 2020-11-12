import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        char[] chars = s.toCharArray();
        LinkedHashMap<Character,Boolean> map = new LinkedHashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)){
                map.put(aChar,false);
            }
            else {
                map.put(aChar,true);
            }
        }
        for (char aChar : chars) {
            if (map.get(aChar)) return aChar;
        }
        return ' ';
    }


    @Test
    public void test(){
        String s ="aadadaad";
        char res = firstUniqChar(s);
        System.out.println(res);
    }
}
