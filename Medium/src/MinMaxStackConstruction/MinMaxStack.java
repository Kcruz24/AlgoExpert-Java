package MinMaxStackConstruction;

import java.util.LinkedList;

public class MinMaxStack
{
    private final LinkedList<Integer> stack = new LinkedList<>();

    public int peek() {
        // Write your code here.
        return stack.get(0);
    }

    public int pop() {
        // Write your code here.
        return stack.remove(0);
    }

    public void push(Integer number) {
        // Write your code here.
        stack.addFirst(number);
    }

    public int getMin() {
        // Write your code here.
        LinkedList<Integer> tempStack = new LinkedList<>(stack);
        int min = tempStack.pop();

        while (isNotEmpty(tempStack)) {
            int top = tempStack.pop();

            if (top < min)
                min = top;
        }

        return min;
    }

    public int getMax() {
        // Write your code here.
        LinkedList<Integer> tempStack = new LinkedList<>(stack);
        int max = tempStack.pop();

        while (isNotEmpty(tempStack)) {
            int top = tempStack.pop();

            if (top > max)
                max = top;
        }

        return max;
    }

    public boolean isNotEmpty(LinkedList<Integer> stack) {
        return stack.peek() != null;
    }

    public void printStack() {
        System.out.print("Stack: ");

        while (isNotEmpty(stack)) {
            System.out.print(stack.pop() + " ");
        }
    }
}
