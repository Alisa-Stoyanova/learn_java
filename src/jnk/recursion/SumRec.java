package jnk.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SumRec {
    public static void main(String[] args) {
        int[] ary = {1, 2, 3, 4, 5}; // sum is 15
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ary.length; i++) {
            stack.push(ary[i]);
            list.add(ary[i]);
        }
        System.out.println(sumAry(ary, 0));
        System.out.println(sumStack(stack));
    }

    public static int sumAry(int[] ary, int cursor) {
        if (ary.length - cursor == 0) { // (ary.length - cursor == 1)
            return 0; // return ary[cursor]
        } else {
            return ary[cursor++] + sumAry(ary, cursor);
        }
    }

    public static int sumStack(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            return stack.pop() + sumStack(stack);
        }
    }

    public static int sumArrayList(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return 0;
        } else {
            return list.remove(0) + sumArrayList(list);
        }
    }
}