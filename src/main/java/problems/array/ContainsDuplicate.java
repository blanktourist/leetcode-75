package main.problems.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears 
 * at least twice in the array, and return false if every element 
 * is distinct.
 * 
 * Ex. 1
 * Input: nums = [1,2,3,1]
 * Output: true
 * 
 * Ex. 2
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Ex. 3
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {
   
   public static boolean containsDuplicate(int[] arr) {
       Set<Integer> seen = new HashSet<>();
       for (int i : arr) {
           if (seen.contains(i)) {
               return true;
           }
           seen.add(i);
       }
       return false;
   }
   public static void main(String[] args) {
       int[] test1 = {1,2,3,1};
       int[] test2 = {1,2,3,4};
       int[] test3 = {1,1,1,3,3,4,3,2,4,2};

       System.out.println(containsDuplicate(test1));
       System.out.println(containsDuplicate(test2));
       System.out.println(containsDuplicate(test3));
   } 
}
