package main.problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
    public static ArrayList<ArrayList<String>> groupAnagrams(ArrayList<String> words) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String word : words) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String sorted = new String(wordArray);
            if (map.containsKey(sorted)) {
                ArrayList<String> value = map.get(sorted);
                value.add(word);
            } else {
                map.put(sorted, new ArrayList<>(Arrays.asList(word)));
            }
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (ArrayList<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }

    public static void main(String[] args) {
        
        ArrayList<String> test1 = new ArrayList<>(Arrays.asList("eat","tea","tan","ate","nat","bat"));
        System.out.println(groupAnagrams(test1));
    }
}
