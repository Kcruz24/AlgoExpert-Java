package ShiftLinkedList;

public class ShiftLinkedListApp
{
    // O(N) space || O(1) space
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        LinkedList trav = head;
        LinkedList prev = null;
        LinkedList newHead;

        int position;
        int counter = 0;

        if (k > 0) {
            int offset = k % size(head) == k ? k : k % size(head);
            position = offset != 0 ? size(head) - offset : 0;
        } else {
            position = Math.abs(k % size(head));
        }

        while (trav != null && position > counter) {
            prev = trav;
            trav = trav.next;

            counter++;
        }

        newHead = trav;

        if (counter > 0) {
            prev.next = null;

            while (trav.next != null) trav = trav.next;

            trav.next = head;
        }

        return newHead;
    }

    public static int size(LinkedList head) {
        int count = 0;

        LinkedList trav = head;

        while (trav != null) {
            count++;
            trav = trav.next;
        }

        return count;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
