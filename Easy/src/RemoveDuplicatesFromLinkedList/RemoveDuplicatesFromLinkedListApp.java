package RemoveDuplicatesFromLinkedList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesFromLinkedListApp
{
    public static void main(String[] args) {
        List<Integer> linkedList = new java.util.LinkedList<>() {{
            add(1);
            add(1);
            add(1);
            add(3);
            add(4);
            add(4);
            add(4);
            add(5);
            add(6);
            add(6);
        }};


    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        var trav = linkedList;

        while (trav != null) {
            var nextNode = trav.next;
            while (nextNode != null && nextNode.value == trav.value) {
                nextNode = nextNode.next;
            }

            trav.next = nextNode;
            trav = nextNode;
        }

        return linkedList;
    }

    public static LinkedList addMany(LinkedList ll, List<Integer> values) {
        LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    public static List<Integer> getNodesInArray(LinkedList ll) {
        List<Integer> nodes = new ArrayList<>();
        LinkedList current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }

    @Test
    public void TestCase1() {
        LinkedList input = new LinkedList(1);
        addMany(input, new ArrayList<>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6));
        LinkedList output = removeDuplicatesFromLinkedList(input);
        assertEquals(getNodesInArray(output), expectedNodes);
    }
}
