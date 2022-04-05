public class LongestRepeatingCharacterReplacement {
    
    public static int returnSolutionToLongestRepeatingCharacterReplacement(String s, int k) {
        int globalMax = 0;
        int[] count = new int[26];
        int topCharCount = 0;
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            count[s.charAt(r) - 'A']++;
            topCharCount = Math.max(topCharCount, count[s.charAt(r) - 'A']);
            while (r - l + 1 - topCharCount > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            globalMax = Math.max(globalMax, r - l + 1);
            r++;
        }

        return globalMax;
    }

    public static void main(String[] args) {
        String test1s = "ABAB";
        int test1k = 2;
        String test2s = "AABABBA";
        int test2k = 1;

        System.out.println(returnSolutionToLongestRepeatingCharacterReplacement(test1s, test1k));
        System.out.println(returnSolutionToLongestRepeatingCharacterReplacement(test2s, test2k));
    }
}
