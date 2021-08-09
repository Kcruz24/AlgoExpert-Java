package ReverseLinkedList;

public class ReverseLinkedListApp
{
    public static void main(String[] args) {
        System.out.println("hola");
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        // Write your code here.
        LinkedList trav = head;
        LinkedList prev = trav;
        LinkedList thirdNode = prev;
        int counter = 0;

        while (trav != null) {
            trav = trav.next;

            if (counter == 0) {
                thirdNode.next = null;
                prev = trav;

                if (trav == null)
                    break;

                trav = trav.next;
            }

            prev.next = thirdNode;
            thirdNode = prev;
            prev = trav;

            counter++;
        }

        return thirdNode;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
