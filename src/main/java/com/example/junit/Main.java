package com.example.junit;

public class Main {
    public static void main(String args[])
    {
        Solution sol = new Solution();
        sol.validAnagram("cat","tac");
        System.out.println(sol.validAnagram("cat","tac"));

        System.out.println(sol.reverseStack("alonso"));

        System.out.println(sol.twoSumLinear(new int[]{2,7,11,15}, 9));

    }
}