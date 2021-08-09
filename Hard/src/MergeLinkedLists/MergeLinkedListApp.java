package MergeLinkedLists;

public class MergeLinkedListApp
{
    public static void main(String[] args) {

    }

    // O(N + M) time || O(1) space - Where N is the number of nodes in the first linked list
    // and M is the number of nodes in the second linked list
    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        LinkedList travOne = headOne;
        LinkedList prevOne = null;
        LinkedList travTwo = headTwo;

        while (travOne != null && travTwo != null) {
            if (travOne.value < travTwo.value) {
                prevOne = travOne;
                travOne = prevOne.next;
            } else {
                if (prevOne != null) prevOne.next = travTwo;

                prevOne = travTwo;
                travTwo = travTwo.next;
                prevOne.next = travOne;
            }
        }

        if (travOne == null) {
            assert prevOne != null;
            prevOne.next = travTwo;
        }

        assert headTwo != null;
        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    public static LinkedList mergeLinkedListsOg(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        LinkedList travOne = headOne;
        LinkedList prevOne = travOne;
        LinkedList travTwo = headTwo;
        LinkedList prevTwo = travTwo;

        while (travOne != null || travTwo != null) {
            if (travOne != null) travOne = travOne.next;
            if (travTwo != null) travTwo = travTwo.next;

            if (prevOne != null && prevTwo != null && travTwo != null) {
                if (prevOne.value < travTwo.value && travOne.value > prevTwo.value) {
                    prevOne.next = prevTwo.next;
                    prevTwo.next = prevOne;
                } else {

                    while (prevOne.value > travTwo.value) {
                        travOne = travOne.next;
                        travTwo = travTwo.next;
                    }

                    if (prevOne.value > prevTwo.value) {
                        prevOne.next = prevTwo.next;
                        prevTwo.next = prevOne;
                    }
                }
            }

            if (travOne != null && travTwo != null) {
                if (travOne.value < travTwo.value) {
                    prevOne.next = travOne;
                }
            }


            if (prevOne != null && prevTwo != null && travOne != null && travTwo != null) {
                if (prevOne.value < travTwo.value && prevTwo.value > prevOne.value) {
                    while (travOne != null && prevOne.value < travTwo.value && prevTwo.value > prevOne.value) {
                        prevOne = prevOne.next;
                        travOne = travOne.next;
                    }

                    prevOne.next = prevTwo;
                }
            }


            prevTwo = travTwo;
            prevOne = travOne;
        }

        assert false;
        if (headOne.value < headTwo.value)
            return headOne;

        return headTwo;
    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
