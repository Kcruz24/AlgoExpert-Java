package LinkedListConstruction;

import LinkedListConstruction.LinkedListConstructionApp.DoublyLinkedList;
import LinkedListConstruction.LinkedListConstructionApp.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LinkedListConstructionAppTest
{
    DoublyLinkedList linkedList = new DoublyLinkedList();
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node three2 = new Node(3);
    Node three3 = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);
    Node seven = new Node(7);


    private List<Integer> getNodeValuesHeadToTail(DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<>();
        Node node = linkedList.head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    private List<Integer> getNodeValuesTailToHead(DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<>();
        Node node = linkedList.tail;
        while (node != null) {
            values.add(node.value);
            node = node.prev;
        }
        return values;
    }

    private void bindNodes(Node nodeOne, Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }

    private boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private void bindingNodes() {
//        bindNodes(four, three);
//        bindNodes(three, two);
//        bindNodes(two, one);

        bindNodes(one, two);
        bindNodes(two, three);
////        bindNodes(three, three2);
////        bindNodes(three2, three3);
        bindNodes(three, four);
        bindNodes(four, five);
        bindNodes(five, six);
        bindNodes(six, seven);
        linkedList.head = one;
        linkedList.tail = seven;
    }

    private void printList() {
        Node trav = linkedList.head;

        System.out.print("HEAD <-> ");

        while (trav != null) {
            System.out.print(trav.value + " <-> ");
            trav = trav.next;
        }

        System.out.print("Tail\n");
    }

    ///////////////////////////////// TESTS ////////////////////////////

    /////////////////////////// Testing setHead() //////////////////////
    @Test
    public void testSetHead() {
        bindingNodes();

        printList();
        linkedList.setHead(one);
        printList();
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {1, 4, 3, 2}));
//        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5}));
//        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {5, 3, 2, 1, 4}));
    }

    /////////////////////////// Testing setTail() //////////////////////
    @Test
    public void testSetTail() {
        bindingNodes();

        printList();
        //linkedList.setHead(four);

        linkedList.setTail(one);
        printList();

        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {2, 3, 4, 1}));
//        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5, 6}));
//        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 3, 2, 1, 4}));
    }

    /////////////////////////// Testing insertBefore() //////////////////////
    @Test
    public void testSetInsertBefore() {
        bindingNodes();

        printList();
        linkedList.setHead(four);
        linkedList.setTail(six);
//        linkedList.setTail(one);

        printList();
        linkedList.insertBefore(six, three);
//        linkedList.insertBefore(one, two);
//        linkedList.insertBefore(two, three);
//        linkedList.insertBefore(three, four);
        printList();
//        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 3, 2, 1}));
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 3, 5, 2, 1, 4}));
    }

    /////////////////////////// Testing insertAfter() //////////////////////
    @Test
    public void testInsertAfter() {
        bindingNodes();

//        linkedList.setHead(four);
//        linkedList.setTail(six);
//        linkedList.insertBefore(six, three);

        printList();
//        linkedList.insertAfter(six, three2);
        linkedList.insertAfter(two, one);
        printList();
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {2, 1, 3, 4}));
//        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6, 3}));
//        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4}));
    }

    /////////////////////////// Testing insertAtPosition() //////////////////////
    @Test
    public void testInsertAtPosition() {
        bindingNodes();

//        linkedList.setHead(four);
//        linkedList.setTail(six);
//        linkedList.insertBefore(six, three);


        printList();
        linkedList.insertAtPosition(2, one);
        printList();
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {1, 2, 3, 4, 5, 6, 7}));
//        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 4, 1, 2, 5, 3, 6, 3}));
//        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4, 3}));
    }

    /////////////////////////// Testing removeNodesWithValue() //////////////////////
    @Test
    public void testRemoveNodesWithValue() {
        bindingNodes();
        linkedList.setHead(four);
        linkedList.setTail(six);
        linkedList.insertBefore(six, three);
        linkedList.insertAfter(six, three2);
        linkedList.insertAtPosition(1, three3);

        printList();
        linkedList.removeNodesWithValue(3);
        printList();
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 2, 1, 4}));
    }

    /////////////////////////// Testing getNodeValuesHeadToTail() //////////////////////


    @Test
    public void testRemove() {
        bindingNodes();

//        linkedList.setHead(four);
//        linkedList.setTail(six);
//        linkedList.insertBefore(six, three);
//        linkedList.insertAfter(six, three2);
//        linkedList.insertAtPosition(1, three3);
//        linkedList.removeNodesWithValue(3);

        printList();
        linkedList.remove(four);
        printList();
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {1, 2, 3}));
//        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 1, 4}));
    }

    @Test
    public void testContainsNodeWithValue() {
        bindingNodes();

        assertTrue(linkedList.containsNodeWithValue(5));
    }
}
