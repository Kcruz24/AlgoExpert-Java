package FindLoop;

public class FindLoopApp
{
    // O(N) time || O(1) space
    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        LinkedList trav = head.next;
        LinkedList prev = head;

        if (prev.value < trav.value) {
            while (prev.value < trav.value && trav.next.value > prev.value) {
                prev = trav;
                trav = trav.next;
            }
        } else if (prev.value > trav.value) {
            while (prev.value > trav.value) {
                prev = trav;
                trav = trav.next;
            }
        } else {
            // The list is full of zeros or equal numbers
            return isZeroList(head);
        }

        return trav;
    }

    public static LinkedList isZeroList(LinkedList head) {
        LinkedList trav = head.next;
        LinkedList prev = head;
        prev.value++;

        while (prev.value > trav.value) {
            trav.value++;
            prev = trav;
            trav = trav.next;
        }

        LinkedList newTrav = trav;
        LinkedList newPrev = newTrav;

        newTrav.value--;

        newTrav = newTrav.next;
        while (newTrav.value > newPrev.value) {
            newTrav.value--;
            newPrev = newTrav;
            newTrav = newTrav.next;
        }

        return newTrav.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
