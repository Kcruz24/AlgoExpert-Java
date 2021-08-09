package SumOfLinkedLists;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SumOfLinkedListsApp
{
    public static void main(String[] args) {
        int test = (5 + 7) / 10;

        System.out.println(test);

    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // O(N + M) time | O(max(M, N)) space - Where N is the length of the first linkedList and M is the length of the second linkedlist
    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        int digitResult = (linkedListOne.value + linkedListTwo.value) % 10;
        int carryOver = (linkedListOne.value + linkedListTwo.value) / 10;

        LinkedList resultList = new LinkedList(digitResult);
        LinkedList travOne = linkedListOne;
        LinkedList travTwo = linkedListTwo;

        int sizeOne = 0;
        int sizeTwo = 0;

        while (travOne != null) {
            sizeOne++;
            travOne = travOne.next;
        }

        while (travTwo != null) {
            sizeTwo++;
            travTwo = travTwo.next;
        }

        travOne = linkedListOne.next;
        travTwo = linkedListTwo.next;
        LinkedList travResult = resultList;

        if (sizeOne == 1 && sizeTwo == 1) {
            if (carryOver > 0)
                travResult.next = new LinkedList(carryOver);

            return resultList;
        }

        if (sizeOne == sizeTwo) {
            while (travOne != null) {
                if (carryOver > 0)
                    digitResult = (travOne.value + travTwo.value) % 10 + carryOver;
                else
                    digitResult = (travOne.value + travTwo.value) % 10;


                travResult.next = new LinkedList(digitResult);

                carryOver = (travOne.value + travTwo.value) / 10;

                travOne = travOne.next;
                travTwo = travTwo.next;
                travResult = travResult.next;
            }

            if (carryOver > 0) {
                travResult.next = new LinkedList(carryOver);
            }
        } else if (sizeOne > sizeTwo) {
            while (travTwo != null) {
                if (carryOver > 0)
                    digitResult = (travOne.value + travTwo.value) % 10 + carryOver;
                else
                    digitResult = (travOne.value + travTwo.value) % 10;

                travResult.next = new LinkedList(digitResult);

                carryOver = (travOne.value + travTwo.value) / 10;

                travOne = travOne.next;
                travTwo = travTwo.next;
                travResult = travResult.next;
            }

            while (travOne != null) {
                if (carryOver > 0)
                    travResult.next = new LinkedList(travOne.value + carryOver);
                else
                    travResult.next = new LinkedList(travOne.value);

                carryOver = 0;

                travOne = travOne.next;
                travResult = travResult.next;
            }
        } else {
            while (travOne != null) {
                if (carryOver > 0)
                    digitResult = (travOne.value + travTwo.value) % 10 + carryOver;
                else
                    digitResult = (travOne.value + travTwo.value) % 10;

                travResult.next = new LinkedList(digitResult);

                carryOver = (travOne.value + travTwo.value) / 10;

                travOne = travOne.next;
                travTwo = travTwo.next;
                travResult = travResult.next;
            }

            while (travTwo != null) {
                if (carryOver > 0)
                    travResult.next = new LinkedList(travTwo.value + carryOver);
                else
                    travResult.next = new LinkedList(travTwo.value);

                carryOver = 0;

                travTwo = travTwo.next;
                travResult = travResult.next;
            }
        }

        return resultList;
    }

    //////////////////////////// SANDBOX //////////////////////////////////

    @Test
    public void TestCase1() {
//        LinkedList ll1 = addMany(new LinkedList(2), new int[] {4, 7, 1});
//        LinkedList ll2 = addMany(new LinkedList(9), new int[] {4, 5});

        LinkedList ll3 = addMany(new LinkedList(1), new int[] {1, 1});
        LinkedList ll4 = addMany(new LinkedList(9), new int[] {9, 9});

//        LinkedList expected = addMany(new LinkedList(1), new int[] {9, 2, 2});
//        LinkedList actual = sumOfLinkedLists(ll1, ll2);

        LinkedList expected2 = addMany(new LinkedList(0), new int[] {1, 1, 1});
        LinkedList actual2 = sumOfLinkedLists(ll3, ll4);

        assertEquals(getNodesInArray(expected2), getNodesInArray(actual2));
    }

    public static LinkedList addMany(LinkedList linkedList, int[] values) {
        var current = linkedList;
        while (current.next != null) {
            current = current.next;
        }
        for (var value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return linkedList;
    }

    public static ArrayList<Integer> getNodesInArray(LinkedList linkedList) {
        ArrayList<Integer> nodeValues = new ArrayList<>();
        LinkedList current = linkedList;
        while (current != null) {
            nodeValues.add(current.value);
            current = current.next;
        }
        return nodeValues;
    }
}
