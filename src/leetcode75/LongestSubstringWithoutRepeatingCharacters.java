import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int returnLengthOfLongestSubstringWithoutRepeatingCharacters(String s) {
        int[] count = new int[128];
        int l = 0;
        int r = 0;
        int max = 0;

        while (r < s.length()) {
            char next = s.charAt(r);
            count[next]++;

            while (count[next] > 1) {
                char prev = s.charAt(l);
                count[prev]--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }

    public static void main(String[] args) {
        
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        String test4 = "abcdeafghijk";

        System.out.println(returnLengthOfLongestSubstringWithoutRepeatingCharacters(test1));
        System.out.println(returnLengthOfLongestSubstringWithoutRepeatingCharacters(test2));
        System.out.println(returnLengthOfLongestSubstringWithoutRepeatingCharacters(test3));
        System.out.println(returnLengthOfLongestSubstringWithoutRepeatingCharacters(test4));
    }
}
