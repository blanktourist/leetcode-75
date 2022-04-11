import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String returnMinimumWindowSubstring(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

        // Dictionary keeps track of all counts of characters of t
        Map<Character,Integer> dictT = new HashMap<>();
        for (int i = 0; i< t.length(); i++) {
            char c = t.charAt(i);
            int count = dictT.getOrDefault(c, 0);
            dictT.put(c, count + 1);
        }

        // Number of unique characters in t
        int requiredCharacters = dictT.size();
        // Tracks the number of unique characters in t which are satisfied in the current window
        int formed = 0;

        int l = 0;
        int r = 0;

        // Track the characters in the current winow
        Map<Character,Integer> current = new HashMap<>();

        // Track our answer: {length of window, l , r}
        int[] ans = {-1, 0, 0};
        

        while (r < s.length()) {
            // Extend window on right
            char c = s.charAt(r);
            current.put(c, current.getOrDefault(c, 0) + 1);

            // Check if formed is updated
            if (dictT.containsKey(c) && current.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // If we have a desirable window, contract on the left while tracking the min window, contract until the window is not desirable
            while (l <= r && formed == requiredCharacters) {
                c = s.charAt(l);
                
                // Save smallest window until now
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                current.put(c, current.get(c) - 1);
                if (dictT.containsKey(c) && current.get(c).intValue() < dictT.get(c).intValue()) {
                    formed --;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC"; 
        String t = "ABC";

        System.out.println(returnMinimumWindowSubstring(s, t));
    }
}
