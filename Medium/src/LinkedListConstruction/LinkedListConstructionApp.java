package LinkedListConstruction;

public class LinkedListConstructionApp
{
    public static void main(String[] args) {
        System.out.println("hola");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        LinkedListConstructionAppTest test =  new LinkedListConstructionAppTest();

        test.testSetHead();
    }

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            if (isEmpty()) {
                head = node;
                tail = node;
                return;
            }

            if (containsNodeWithValue(node.value)) {
                if (node == tail) {
                    tail = tail.prev;
                } else {
                    if (node.prev != null) node.prev.next = node.next;
                    if (node.next != null) node.next.prev = node.prev;
                }

                remove(node);
            }

            addBack(node);
        }

        public void addBack(Node node) {
            node.next = head;

            head = node;
            head.prev = null;
        }

        public void addTail(Node node) {
            tail.next = node;
            node.prev = tail;

            tail = node;
            tail.next = null;
        }

        public void setTail(Node node) {
            // Write your code here.
            if (isEmpty()) {
                head = node;
                tail = node;
                return;
            }

            if (node == head) {
                head = head.next;
                head.prev = null;
            } else {
                if (node.prev != null) node.prev.next = node.next;
                if (node.next != null) node.next.prev = node.prev;
            }

            addTail(node);
        }

        //////////////////////////////////// insertBefore() ////////////////////////////////////////
        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            if (isEmpty())
                return;

            if (nodeToInsert == tail) {
                tail = nodeToInsert.prev;

                nodeToInsert.prev = node.prev;
                nodeToInsert.next = node;

                if (node.prev != null) node.prev.next = nodeToInsert;

                node.prev = nodeToInsert;
                node.next = null;
            } else if (node == head) {

                if (nodeToInsert.next != null) nodeToInsert.next.prev = node;

                nodeToInsert.next = node;
                node.prev = nodeToInsert;

                nodeToInsert.prev = null;

                head = nodeToInsert;
            } else {
                if (nodeToInsert.prev != null) nodeToInsert.prev.next = nodeToInsert.next;
                if (nodeToInsert.next != null) nodeToInsert.next.prev = nodeToInsert.prev;

                nodeToInsert.prev = node.prev;
                if (node.prev != null) node.prev.next = nodeToInsert;

                nodeToInsert.next = node;
                node.prev = nodeToInsert;
            }
        }

        ///////////////////////////////////////// insertAfter() ////////////////////////////////////////
        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            if (isEmpty())
                return;

            if (node == tail) {
                node.next = nodeToInsert;
                nodeToInsert.prev = node;

                nodeToInsert.next = null;

                tail = nodeToInsert;
            } else {
                nodeToInsert.prev = node;
                nodeToInsert.next = node.next;

                node.next = nodeToInsert;
                nodeToInsert.next.prev = nodeToInsert;

                if (nodeToInsert == head) {
                    setHead(node);
                }
            }
        }

        //////////////////////////////// insertAtPosition() /////////////////////////////////////
        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
            if (isEmpty()) {
                head = nodeToInsert;
                tail = nodeToInsert;
                return;
            }

            Node trav = head;
            int index = 1;

            while (index != position) {
                trav = trav.next;
                index++;
            }

            remove(nodeToInsert);
            insertBefore(trav, nodeToInsert);
        }

        ///////////////////////////////////////// removeNodeWithValue() ////////////////////////////////////////
        public void removeNodesWithValue(int value) {
            // Write your code here.
            if (isEmpty()) {
                return;
            }

            Node trav = head;

            while (trav != null) {
                if (trav.value == value && trav == head) {
                    head = head.next;
                } else if (trav.value == value && trav == tail) {
                    trav.prev.next = null;
                    tail = trav.prev;

                    trav.prev = null;
                } else if (trav.value == value){
                    trav.prev.next = trav.next;
                    trav.next.prev = trav.prev;
                }

                trav = trav.next;
            }
        }

        ///////////////////////////////////////// remove() ////////////////////////////////////////
        public void remove(Node node) {
            // Write your code here.
            if (isEmpty())
                return;

            if (node == head) {
                head = head.next;
            } else if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                if (node.prev != null) node.prev.next = node.next;
                if (node.next != null) node.next.prev = node.prev;

                node.next = null;
                node.prev = null;
            }
        }

        ///////////////////////////////////////// isEmpty() ////////////////////////////////////
        public boolean isEmpty() {
            return head == null;
        }

        ///////////////////////////////////////// containsNodeWithValue() ////////////////////////////////////
        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            Node trav = head;

            while (trav != null) {
                if (trav.value == value)
                    return true;

                trav = trav.next;
            }

            return false;
        }

    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}