/*
A stack is a data structure with four main operations (for our case, let's assume it's a stack of ints):

    push(i):    Add i to the top of the stack
    pop():      Remove and return the value on the top of the stack, raising an exception
                if the stack is empty
    peek():     Return, but do not remove, the value on the top of the stack, raising an
                exception if the stack is empty
    is_empty(): Return a boolean that is true if there is nothing on the stack, and false
                otherwise
Given this definition, implement a new class called MaxStack. It should have all the same functionality as a regular stack, as well as a function that returns (but does not remove) the maximum value on the stack in O(1) time. All other functions must continue to return in O(1) time.
 */
/*
 * Click `Run` to execute the snippet below!
 */
package main.java.com.example.junit;

import java.io.*;
import java.util.*;
import java.util.Stack;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution2 {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    //MaxStack sampleObject = new MaxStack();
/*     System.out.println("Is empty: " +sampleObject.is_empty());
    sampleObject.push(3);
        sampleObject.push(5);
            sampleObject.push(7);
                sampleObject.push(7);



    sampleObject.view();
    System.out.println("Max value: " +sampleObject.getMax());

    System.out.println("Peeking:" + sampleObject.peek());
    System.out.println("Poping:" + sampleObject.pop());
System.out.println("Is empty: " +sampleObject.is_empty());
        sampleObject.view(); */
        MaxStack s = new MaxStack();
        s.push(3);
        s.push(5);
        s.getMax();
        s.push(7);
        s.push(19);
        s.getMax();
        s.pop();
        s.getMax();
        s.pop();
        s.peek();
        s.pop();
        s.pop();
        s.peek();
        s.getMax();

  }

  static class MaxStack {
    static final long serialVersionUID = 1L;
    ArrayList<Integer> elementData = new ArrayList<> ();
    public int N;
    public int maxValue;

    public MaxStack () {

    }

    public int getMax() {
        if(elementData.isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }
        else {
            System.out.println("Maximum element in the stack is: " + maxValue);
            return maxValue;
        }
    }

    public boolean is_empty() {
       return elementData.isEmpty();
    }

    public void push(int value) {
        // Insert new number into the stack
        if (elementData.isEmpty())
        {
            maxValue = value;
            elementData.add(value);
            System.out.println("Number Inserted: " + value);
            return;
        }
         
        // If new number is Greater than maxValue
        if (value > maxValue)
        {
            elementData.add(2 * value - maxValue);
            maxValue = value;
        }
         
        else
            elementData.add(value);
         
            System.out.println("Number Inserted: " + value);
    }

    public int pop() {

        if (elementData.isEmpty())
        {
            System.out.println("Stack is empty\n");
            return 0;
        }
        int top = elementData.get(elementData.size() - 1);
		elementData.remove(elementData.size() - 1);
         
        System.out.print("Top Most Element Removed: ");

 
        // Maximum will change as the maximum element
        // of the stack is being removed.
        if (top > maxValue)
        {
            System.out.println(maxValue);
            maxValue = 2 * maxValue - top;
        }
 
        else
            System.out.println(top);
		return top;

    }

    public int peek() {
      //return elementData.get(N);
        if(elementData.isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }
        int top = elementData.get(elementData.size()-1);
        System.out.print("Top Most Element is: ");
        if(top > maxValue)
            System.out.println(maxValue);
        else
            System.out.println(top);
            return top;

    }

  }

}

