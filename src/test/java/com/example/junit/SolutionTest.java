package com.example.junit;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;

import com.example.junit.Solution.ListNode;
import com.example.junit.Solution.SmallestInfiniteSet;
import com.example.junit.Solution.TowerOfHanoiUsingStacks;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class SolutionTest {

    long startTime, endTime;

    @Test
    @DisplayName("linear time complexity - O(n) - Space Complexity O(n) - https://leetcode.com/problems/valid-anagram/solutions/66484/accepted-java-o-n-solution-in-5-lines/?orderBy=most_votes&languageTags=java")
    @Tag("Anagram")
    public void validAnagram() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        boolean res = solution.validAnagram("rat", "tar");
        solution.sayResult(stream, Boolean.toString(res));
        solution.sayResult(System.out, "validAnagram('rat', 'tar'): " + Boolean.valueOf(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Solution.RESULT, System.lineSeparator()))));
    }
    @Test
    @Tag("Anagram")
    public void validAnagramFail() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        boolean res = solution.validAnagram("rat", "tac");
        solution.sayResult(stream, Boolean.toString(res));
        solution.sayResult(System.out, "validAnagram('rat', 'tac'): " + Boolean.valueOf(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Solution.RESULT_FALSE, System.lineSeparator()))));
    }

    @Test
    @DisplayName("linear time complexity - O(n) - Space Complexity O(1)")
    @Tag("Anagram")
    public void validAnagramHashMap() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        boolean res = solution.validAnagramHashMap("rat", "tar");
        solution.sayResult(stream, Boolean.toString(res));
        solution.sayResult(System.out, "validAnagramHashMap('rat', 'tar'): " + Boolean.valueOf(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Solution.RESULT, System.lineSeparator()))));
    }

    @Test
    @DisplayName("linear time complexity - O(n) - https://leetcode.com/problems/reverse-string/solutions/3176623/using-stack/?q=stack&orderBy=most_relevant&languageTags=java")
    @Tag("Reverse")
    public void reverseStack() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        String res = solution.reverseStack("Welcome");
        solution.sayResult(stream, res);
        solution.sayResult(System.out, "validAnagramHashMap('Welcome', 'emocleW'): " + res);

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Solution.REVERSE, System.lineSeparator()))));
    }

    @Test
    @DisplayName("linear time complexity - O(n)")
    @Tag("Reverse")
    public void reverse() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        String res = solution.reverse("Welcome");
        solution.sayResult(stream, res);
        solution.sayResult(System.out, "validAnagramHashMap('Welcome', 'emocleW'): " + res);

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Solution.REVERSE, System.lineSeparator()))));
    }

    @Test
    @DisplayName("constant time complexity - O(1)")
    @Tag("Reverse")
    public void reverseOptimized() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        String res = solution.reverseOptimized("Welcome");
        solution.sayResult(stream, res);
        solution.sayResult(System.out, "validAnagramHashMap('Welcome', 'emocleW'): " + res);

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Solution.REVERSE, System.lineSeparator()))));
    }

    @Test
    @DisplayName("linear time complexity - O(n)")
    @Tag("TwoSum")
    public void twoSum() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        int[] res = solution.twoSumLinear(new int[]{2,7,11,15}, 9);
        solution.sayResult(stream, Arrays.toString(res));
        solution.sayResult(System.out, "twoSumLinear(new int[]{2,7,11,15}, 9): " + Arrays.toString(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Arrays.toString(Solution.TWOSUM), System.lineSeparator()))));
    }

    @Test
    @DisplayName("polynomial complexity n^x - O(n^2)")
    @Tag("TwoSum")
    public void twoSumBrute() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        int[] res = solution.twoSumBrute(new int[]{2,7,11,15}, 9);
        solution.sayResult(stream, Arrays.toString(res));
        solution.sayResult(System.out, "twoSum(new int[]{2,7,11,15}, 9): " + Arrays.toString(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Arrays.toString(Solution.TWOSUM), System.lineSeparator()))));
    }

    @Test
    @DisplayName("linear complexity - O(n)")
    @Tag("Search")
    public void linearSearch() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        int res = solution.linearSearch(new int[]{4,5,6,7,0,1,2}, 0);
        endTime = System.nanoTime();

        System.out.println("That took " + (endTime - startTime) + " ns");
        solution.sayResult(stream, Integer.toString(res));
        solution.sayResult(System.out, "linearSearch(new int[]{4,5,6,7,0,1,2}, 0): " + Integer.toString(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Integer.toString(Solution.SEARCH), System.lineSeparator()))));
    }

    @Test
    @DisplayName("logarithmic complexity - O(log n) - https://leetcode.com/problems/search-insert-position/solutions/15080/My-8-line-Java-solution/")
    @Tag("Search")
    public void binarySearch() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        int res = solution.binarySearch(new int[]{4,5,6,7,0,1,2}, 0);
        endTime = System.nanoTime();

        System.out.println("That took " + (endTime - startTime) + " ns");
        solution.sayResult(stream, Integer.toString(res));
        solution.sayResult(System.out, "binarySearch(new int[]{4,5,6,7,0,1,2}, 0): " + Integer.toString(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Integer.toString(Solution.SEARCH), System.lineSeparator()))));
    }

    @Test    
    @DisplayName("logarithmic complexity - O(logn) - https://leetcode.com/problems/merge-two-sorted-lists/solutions/9715/java-1-ms-4-lines-codes-using-recursion/")
    @Tag("MergeTwoLists")
    public void mergeTwoLists() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        ListNode list1 = ListNode.createList(new int[]{1, 2, 4});  
        ListNode list2 = ListNode.createList(new int[]{1, 3, 4});

        ListNode res = solution.mergeTwoLists(list1, list2);
        endTime = System.nanoTime();

        System.out.println("That took " + (endTime - startTime)/1000 + " us");
        solution.sayResult(stream, res.toString());
        solution.sayResult(System.out, "mergeTwoLists(): " + res.toString() + " Expected: " + Solution.LISTMERGE.toString());

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Solution.LISTMERGE.toString(), System.lineSeparator()))));
        //assertThat(2, is(res.filter(x -> x.val == 2).val));
        assertThat(Solution.LISTMERGE, is(equalTo(res)));


    }

    @Test
    @DisplayName("linear complexity - O(n)")
    @Tag("MergeTwoLists")
    public void mergeTwoListsIterative() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        ListNode list1 = ListNode.createList(new int[]{1, 2, 4});  
        ListNode list2 = ListNode.createList(new int[]{1, 3, 4});

        ListNode res = solution.mergeTwoListsIterative(list1, list2);
        endTime = System.nanoTime();

        System.out.println("That took " + (endTime - startTime)/1000 + " us");
        solution.sayResult(stream, res.toString());
        solution.sayResult(System.out, "mergeTwoListsIterative(): " + res.toString() + " Expected: " + Solution.LISTMERGE.toString());

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Solution.LISTMERGE.toString(), System.lineSeparator()))));
        //assertThat(2, is(res.filter(x -> x.val == 2).val));
        assertThat(Solution.LISTMERGE, is(equalTo(res)));


    }

    @Test
    @DisplayName("logaritmic complexity - O(logn)")
    @Tag("MergeTwoLists")
    public void mergeTwoListsRecursive2() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        ListNode list1 = ListNode.createList(new int[]{1, 2, 4});  
        ListNode list2 = ListNode.createList(new int[]{1, 3, 4});

        ListNode res = solution.mergeTwoListsRecursive2(list1, list2);
        endTime = System.nanoTime();

        System.out.println("That took " + (endTime - startTime)/1000 + " us");
        solution.sayResult(stream, res.toString());
        solution.sayResult(System.out, "mergeTwoListsRecursive2(): " + res.toString() + " Expected: " + Solution.LISTMERGE.toString());

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Solution.LISTMERGE.toString(), System.lineSeparator()))));
        //assertThat(2, is(res.filter(x -> x.val == 2).val));
        assertThat(Solution.LISTMERGE, is(equalTo(res)));


    }

    @Test
    @DisplayName("linear complexity - O(n) - https://leetcode.com/problems/maximum-subarray/solutions/1595186/java-kadane-divide-and-conquer-dp/?orderBy=most_votes&languageTags=java")
    @Tag("MaxSubarray")
    public void maxSubArray() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        int res = solution.maxSubArray(new int[]{5,4,-1,7,8});
        endTime = System.nanoTime();
        System.out.println(new Throwable()
        .getStackTrace()[0]
        .getMethodName()+ 
        " took " + (endTime - startTime)/1000 + " us");

        solution.sayResult(stream, Integer.toString(res));
        solution.sayResult(System.out, "maxSubArray(new int[]{5,4,-1,7,8}): " + Integer.toString(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Integer.toString(Solution.MAXSUBARRAY), System.lineSeparator()))));
    }

    @Test
    @DisplayName("loglinear complexity - O(n log n) concept of halving. Every time n increases by an amount k, the time or space increases by k/2. There are several common algorithms that are O(logn) a vast majority of the time, including: binary search, searching for a term in a binary search tree and adding items to a heap.")
    @Tag("MaxSubarray")
    public void maxSubArrayDivide() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        int res = solution.maxSubArrayDivide(new int[]{5,4,-1,7,8});
        endTime = System.nanoTime();
        System.out.println(new Throwable()
        .getStackTrace()[0]
        .getMethodName()+ 
        "That took " + (endTime - startTime)/1000 + " us");

        solution.sayResult(stream, Integer.toString(res));
        solution.sayResult(System.out, "maxSubArrayDivide(new int[]{5,4,-1,7,8}): " + Integer.toString(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Integer.toString(Solution.MAXSUBARRAY), System.lineSeparator()))));
    }

    @Test
    @DisplayName("https://leetcode.com/problems/smallest-number-in-infinite-set/solutions/3452223/easiest-java-solution-with-proper-explanation/?orderBy=most_votes&languageTags=java")
    @Tag("SmallestInfiniteSet")
    public void smallestInfiniteSet() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        PriorityQueue<String> pQueue = new PriorityQueue<String>();
        String[] actionFilter = {"SmallestInfiniteSet","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","popSmallest"};
        pQueue.addAll(Arrays.asList(actionFilter));

        Integer arr[] = { null, 2, null, null, null, 1, null, null, null };
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        SmallestInfiniteSet solution = new SmallestInfiniteSet((HashSet)set);
        solution.addBack(2);
        solution.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
        solution.popSmallest(); // return 2, and remove it from the set.
        solution.popSmallest(); // return 3, and remove it from the set.
        solution.addBack(1);    // 1 is added back to the set.
        solution.popSmallest(); // return 1, since 1 was added back to the set and
                                           // is the smallest number, and remove it from the set.
        solution.popSmallest(); // return 4, and remove it from the set.
        solution.popSmallest();
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(solution.pq.toArray()));

        System.out.println(new Throwable()
        .getStackTrace()[0]
        .getMethodName()+ 
        "That took " + (endTime - startTime)/1000 + " us");

        //solution.sayResult(stream, Integer.toString(res));
        //solution.sayResult(System.out, "smallestInfiniteSet(): " + Integer.toString(res));

        //assertThat(os.toString(), is(equalTo(String.format("%s%s", Integer.toString(Solution.MAXSUBARRAY), System.lineSeparator()))));
    }

    @Test
    @DisplayName("exponential time - O(2^n)")
    @Tag("TowerOfHanoi")
    public void towerOfHanoi() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        int n = 4;
        solution.towerOfHanoi(n, 'A', 'C', 'B');
        endTime = System.nanoTime();
        System.out.println(new Throwable()
        .getStackTrace()[0]
        .getMethodName()+ 
        "That took " + (endTime - startTime)/1000 + " us");

        //solution.sayResult(stream, Integer.toString(res));
        //solution.sayResult(System.out, "maxSubArrayDivide(new int[]{5,4,-1,7,8}): " + Integer.toString(res));

        //assertThat(os.toString(), is(equalTo(String.format("%s%s", Integer.toString(Solution.MAXSUBARRAY), System.lineSeparator()))));
    }

    @Test
    @DisplayName("exponential time - O(2^n)")
    @Tag("TowerOfHanoiStacks")
    public void towerOfHanoiStacks() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);
        Stack<Integer>[] tower = new Stack[4]; 

        tower[1] = new Stack<Integer>();
        tower[2] = new Stack<Integer>();
        tower[3] = new Stack<Integer>();
        /* Accepting number of disks */         
        int num = 4;
        TowerOfHanoiUsingStacks solution = new TowerOfHanoiUsingStacks(num, tower);
        TowerOfHanoiUsingStacks.toh(num);
        endTime = System.nanoTime();
        System.out.println(new Throwable()
        .getStackTrace()[0]
        .getMethodName()+ 
        "That took " + (endTime - startTime)/1000 + " us");

        //solution.sayResult(stream, Integer.toString(res));
        //solution.sayResult(System.out, "maxSubArrayDivide(new int[]{5,4,-1,7,8}): " + Integer.toString(res));

        //assertThat(os.toString(), is(equalTo(String.format("%s%s", Integer.toString(Solution.MAXSUBARRAY), System.lineSeparator()))));
    }

    @Test
    @DisplayName("exponential time - O(2^n)")
    @Tag("CoinChange")
    public void coinChange() {
        startTime = System.nanoTime();

        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Solution solution = new Solution();
        int n = 4;
        int res = solution.coinChange(new int[]{1,2,5}, 11);
        endTime = System.nanoTime();
        System.out.println(new Throwable()
        .getStackTrace()[0]
        .getMethodName()+ 
        " took " + (endTime - startTime)/1000 + " us");

        solution.sayResult(stream, Integer.toString(res));
        solution.sayResult(System.out, "coinChange(new int[]{1,2,5}, 11): " + Integer.toString(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Integer.toString(Solution.COINCHANGE), System.lineSeparator()))));
    }
/*     @Test
    public void reverseList() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);
        //ArrayList<Integer> list = Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5));
        List<ListNode> list =  new ArrayList(Arrays.asList(1,2,3,4,5));

        ArrayList<ListNode> out = new ArrayList<ListNode>();
        Solution solution = new Solution();
        for (ListNode value: list) {
            ListNode res = solution.reverseList(value);
            out.add(res);
        }

        //solution.sayResult(stream, Arrays.toString(res));
        //solution.sayResult(System.out, "twoSum(new int[]{2,7,11,15}, 9): " + Arrays.toString(res));

        assertThat(os.toString(), is(equalTo(String.format("%s%s", Solution.LIST, System.lineSeparator()))));
    } */

}
