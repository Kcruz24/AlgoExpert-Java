package RemoveKthNodeFromEnd;

public class RemoveKthNodeFromEndApp
{
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList trav = head;
        int size = 0;

        while (trav != null) {
            size++;
            trav = trav.next;
        }

        int kthNodeIndex = size - k;
        trav = head;
        LinkedList prev = trav;
        size = 0;

        while (size < kthNodeIndex) {
            size++;
            prev = trav;
            trav = trav.next;
        }

        if (trav == head) {
            prev = trav;
            trav = trav.next;

            prev.value = trav.value;
            prev.next = trav.next;
            return;
        }

        prev.next = trav.next;
        trav.next = null;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
