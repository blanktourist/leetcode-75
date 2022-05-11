package main.problems.string;

public class ValidPalindrome {
    public static boolean isValidPalindrome(String s) {
        int l = 0;
        int r = s.length() -1;

        while (l < r) {
            while (!Character.isAlphabetic(s.charAt(l))) {
                l++;
            }
            while (!Character.isAlphabetic(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        String test3 = " ";

        System.out.println(isValidPalindrome(test1));
        System.out.println(isValidPalindrome(test2));
        System.out.println(isValidPalindrome(test3));
    }
}
