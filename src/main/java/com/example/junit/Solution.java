package com.example.junit;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;  
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Scanner;


class Solution {

    static final String RESULT = "true";
    static final String RESULT_FALSE = "false";
    static final String REVERSE = "emocleW";
    static final int[] TWOSUM = {0, 1};
    static final int MAXSUBARRAY= 23;
    static final int COINCHANGE = 3;
    static final int SEARCH = 4;
    static final List<ListNode> LIST = new ArrayList(Arrays.asList(1,2,3,4,5));
    static final ListNode LISTMERGE = ListNode.createList(new int[]{1, 1, 2, 3, 4, 4});


    public boolean validAnagram(String s, String t) {
        int[] freq=new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c:t.toCharArray()){
            freq[c-'a']--;
        }
        //return Arrays.stream(freq).allMatch(x->x==0);
        for (int i : freq) if (i != 0) return false;
        return true;
    }

    public boolean validAnagramHashMap(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    
    }

    public String reverseStack(String s) {
        char[] rS = new char[s.length()];  
        // Declaring an st of Character type  
        Stack<Character> st = new Stack<Character>();  
        // Traversing the String and pushing the characters of the string  
        // into the St one by one  
        for (int j = 0; j < s.length(); j++) {  
            // pushing the characters into the St  
            st.push(s.charAt(j));  
        }  
        // Now Poping the Characters from the st until   
        // the st becomes empty  
        int j = 0;  
        while (!st.isEmpty()) { // popping elements until from st  
                                   // st becomes empty  
            // getting the character from the top of the st  
            rS[j++] = st.pop();  
        }  
        // returning the string object  
        return new String(rS);  

        
    }

    public String reverse(String s) {
        String str = "";                   //Allocate extra space
        char[] chars = new char[s.length()];
        for(int i=s.length()-1; i>=0; i--)   /*Add to extra space from rear to front */
            str += s.charAt(i);
        
        for(int i=0; i<s.length(); i++)      /*Set reversed 'str' into char array 's' */
            chars[i] = str.charAt(i);

        return String.valueOf(chars);
    }

    public String reverseOptimized(String s) {
        String out = new StringBuilder(s).reverse().toString();
        return out;
    }

    public int[] twoSumLinear(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public int[] twoSumBrute(int[] nums, int target) {
        int firstNumber, secondNumber;
        for (int i = 0; i < nums.length; i++) {
            firstNumber = nums[i];
            for (int j = 1; j < nums.length; i++) {
                secondNumber = nums[j];
                if (firstNumber+secondNumber == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {-1, -1};
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  
        ListNode current = head;
    
        
        while(current != null) { 
            ListNode next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }
       return prev; 
    }
    
    public void sayResult(PrintStream printer, String s) {
            printer.println(s);
        
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode last = preHead;
        
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                last.next = l2;
                l2 = l2.next;
            } else {
                last.next = l1;
                l1 = l1.next;
            }
            last = last.next;
        }
        
        if(l1 == null) {
            last.next = l2;
        } else {
            last.next = l1;
        }
        
        return preHead.next;
    }

    public ListNode mergeTwoListsRecursive2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
            
            if(list1 == null && list2 == null) return null;  //null checking
            if(list1 == null) return list2;
            if(list2 == null) return list1;
            
            if(list1.val > list2.val) { //comparing and merging
                head = list2;
                list2 = list2.next;
            }
            else {
                head = list1;
                list1 = list1.next;
            }
            
            head.next = mergeTwoListsRecursive2(list1, list2);
            return head;
    }

    public int linearSearch(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
        if(nums[i]==target) return i;
        }
        return -1;
    
    }

    public int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid]
                : target < nums[0] ? Long.MIN_VALUE : Long.MAX_VALUE;
            if (num > target) {
                hi = mid - 1;
            } else if (num < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int maxSubArray(int[] A) {

        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);	
            //System.out.println("i:" + i + "MaxEndingHere:" + maxEndingHere + "MaxSoFar: " + maxSoFar);
        }
        return maxSoFar;
    }

    public int maxSubArrayDivide(int[] nums) {
    
        return helper(nums,0,nums.length-1);
    }

    public void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
    {
        if (n == 1)
        {
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
			return -1;

		if (amount <= 0)
			return 0;

		int dp[] = new int[amount + 1];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int am = 1; am < dp.length; am++) {
			for (int i = 0; i < coins.length; i++) {
				if (coins[i] <= am) {
					int sub = dp[am - coins[i]];
					if (sub != Integer.MAX_VALUE)
						dp[am] = Math.min(sub + 1, dp[am]);
				}
			}
		}
		return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }

    public static class SmallestInfiniteSet {

        PriorityQueue<Integer> pq;
        HashSet<Integer> set;
        int smallest;

        public SmallestInfiniteSet() {
            pq = new PriorityQueue<>();
            set = new HashSet<>();
            smallest = 1;
        }

        public SmallestInfiniteSet(HashSet<Integer> hs) {
            set = hs;
            pq = new PriorityQueue<>();
            smallest = 1;
        }

        public int popSmallest() {
            // System.out.println("popping smallest");
            if (pq.isEmpty()) {
                 System.out.println("pq empty");
                return smallest++;
            }
             System.out.println("pq not empty peek: "+pq.peek());
            set.remove(pq.peek());
            return pq.poll();

        }

        public void addBack(int num) {
             System.out.println("num is "+num+" smallest is "+smallest);
            if (smallest > num) {
                // System.out.println("inside if");
                int sizeprev = set.size();
                set.add(num);
                if (sizeprev < set.size()) {
                    pq.add(num);
                    System.out.println("Adding to PQ: " + pq.peek());

                }
            }

        }
    }

    public int helper(int nums[],int i,int j){

        if(i==j){
            return nums[i];
        }
                          
        int mid  =  (i+j)/2;
        int sum = 0,leftMaxSUM = Integer.MIN_VALUE;
        
        for(int l =  mid;l>=i;l--){
            sum+=nums[l];
            if(sum>leftMaxSUM){
                leftMaxSUM =  sum;
            }                                    
        }
        
     int rightMaxSUM = Integer.MIN_VALUE;
        sum = 0;    // reset sum to 0
        for (int l = mid + 1; l <=j; l++)
        {
            sum += nums[l];
            if (sum > rightMaxSUM ) {
                rightMaxSUM = sum;
            }
        }
        
       int maxLeftRight = Math.max(helper(nums, i, mid),
                                    helper(nums, mid + 1, j ));
        return Math.max(maxLeftRight, leftMaxSUM + rightMaxSUM );
        
        
    
    }

    public static class ListNode {
        int val;
                 ListNode next;
                 ListNode() {}
                 ListNode(int val) { this.val = val; }
                 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
                 public int getVal() {
                     return val;
                 }
                 public static ListNode createList(int[] values) {
                    ListNode head = new ListNode(values[0]);
                    ListNode prev = head;
                    for (int i = 1; i < values.length; i++) {
                        prev.next = new ListNode(values[i]);
                        prev = prev.next;
                    }
                    return head;
                }
                
                @Override
                 public String toString() {

                    return val + "->" + next;
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (o == null || getClass() != o.getClass()) return false;
                    ListNode listNode = (ListNode) o;
                    return val == listNode.val &&
                            Objects.equals(next, listNode.next);
                }
            
                @Override
                public int hashCode() {
                    return Objects.hash(val, next);
                }

                public ListNode filter(Predicate<ListNode> f) {

                    ListNode node = this;
                    while (node != null && !f.test(node)) {
                        node = node.next;
                    }
                    return node;
                }
        }

    public static class TowerOfHanoiUsingStacks {
            public static int N;
            /* Creating Stack array  */
            public static Stack<Integer>[] tower = new Stack[4]; 
        
            public static void main(String[] args)
            {
                Scanner scan = new Scanner(System.in);
                tower[1] = new Stack<Integer>();
                tower[2] = new Stack<Integer>();
                tower[3] = new Stack<Integer>();
                /* Accepting number of disks */         
                System.out.println("Enter number of disks");
                int num = scan.nextInt();
                N = num;
                toh(num);
            }
            
            TowerOfHanoiUsingStacks (int n, Stack<Integer>[] stacks) {
                N=n;
                tower = stacks;
            }
            /* Function to push disks into stack */
            public static void toh(int n)
            {
                for (int d = n; d > 0; d--)
                    tower[1].push(d);
                display();
                move(n, 1, 2, 3);         
            }
            /* Recursive Function to move disks */
            public static void move(int n, int a, int b, int c)
            {
                if (n > 0)
                {
                    move(n-1, a, c, b);     
                    int d = tower[a].pop();                                             
                    tower[c].push(d);
                    display();                   
                    move(n-1, b, a, c);     
                }         
            }
            /*  Function to display */
            public static void display()
            {
                System.out.println("  A  |  B  |  C");
                System.out.println("---------------");
                for(int i = N - 1; i >= 0; i--)
                {
                    String d1 = " ", d2 = " ", d3 = " ";
                    try
                    {
                        d1 = String.valueOf(tower[1].get(i));
                    }
                    catch (Exception e){
                    }    
                    try
                    {
                        d2 = String.valueOf(tower[2].get(i));
                    }
                    catch(Exception e){
                    }
                    try
                    {
                        d3 = String.valueOf(tower[3].get(i));
                    }
                    catch (Exception e){
                    }
                    System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
                }
                System.out.println("\n");         
            }
        }
}