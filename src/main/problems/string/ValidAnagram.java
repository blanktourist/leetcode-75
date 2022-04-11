public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();

        int[] charCount = new int[26];
        
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String test1s = "anagram";
        String test1t = "nagaram";
        String test2s = "rat";
        String test2t = "car";

        System.out.println(isAnagram(test1s, test1t));
        System.out.println(isAnagram(test2s, test2t));
    }
}
