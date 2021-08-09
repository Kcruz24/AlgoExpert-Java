package SortStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class SortStackApp
{
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(-5, 2, -2, 4, 3, 1));

        //System.out.println(test.remove(test.size() - 1));

        System.out.println(sortStack(test));
    }

    public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        ArrayList<Integer> finalStack = new ArrayList<>();
        int range = stack.size();

        for (int i = 0; i < range; i++) {
            int min = getMin(stack);

            finalStack.add(min);

            stack.remove((Integer) min);
        }

        return finalStack;
    }

    public static int getMin(ArrayList<Integer> stack) {
        LinkedList<Integer> tempStack = new LinkedList<>(stack);
        int min = tempStack.pop();

        while (tempStack.peek() != null) {
            int top = tempStack.pop();

            if (top < min)
                min = top;
        }

        return min;
    }
}
