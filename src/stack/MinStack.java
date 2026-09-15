package stack;

import java.util.ArrayDeque;

public class MinStack {
    // ArrayDeque<Integer> stack;
    // PriorityQueue<Integer> minHeap;

    // public MinStack() {
    // minHeap = new PriorityQueue<>();
    // stack = new ArrayDeque<>();
    // }

    // public void push(int value) {
    // stack.push(value);
    // minHeap.offer(value);

    // }

    // public void pop() {
    // int value;
    // if(!stack.isEmpty()) {
    // value = stack.pop();
    // minHeap.remove(value);
    // }
    // }

    // public int top() {

    // return stack.peek();

    // }

    // public int getMin() {
    // return minHeap.peek();
    // }

    ArrayDeque<int[]> stack;
    int min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int value) {
        min = Math.min(min, value);
        stack.push(new int[] { value, min });
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            if (stack.isEmpty()) {
                min = Integer.MAX_VALUE;
            } else {
                min = stack.peek()[1];
            }
        }
    }

    public int top() {

        return stack.peek()[0];

    }

    public int getMin() {
        return stack.peek()[1];
    }
}
