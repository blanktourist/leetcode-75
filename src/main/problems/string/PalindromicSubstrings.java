import java.util.HashSet;
import java.util.List;

public class PalindromicSubstrings {
    public static List<String> findPalindromicSubstrings(String s) {
        HashSet<String> results = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(results, s, i, i);
            expandAroundCenter(results, s, i, i + 1);
        }

        return results.stream().toList();
    }

    public static void expandAroundCenter(HashSet<String> results, String s, int l, int r) {
        while (l >= 0 && r <s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                results.add(s.substring(l, r+1));
                l--;
                r++;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String test1 = "abc";
        String test2 = "babaddabaadbdbabdd";

        System.out.println(findPalindromicSubstrings(test1));
        System.out.println(findPalindromicSubstrings(test2));
    }
}
