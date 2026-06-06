public class LinearLinkedList {

    // Node definition (still needed in Java)
    static class Node {
        int data;
        Node next;
    }

    // Head of the list
    static Node head = null;

    // Insert a node at the end
    public static void insert(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Delete the first occurrence of a node by value
    public static void delete(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node prev = null;
        Node current = head;

        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element not found.");
            return;
        }

        prev.next = current.next;
    }

    // Search for a value in the list
    public static boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Display the list
    public static void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(30);
        display(); // 10 -> 20 -> 30 -> null

        delete(20);
        display(); // 10 -> 30 -> null

        System.out.println("Search 30: " + search(30)); // true
        System.out.println("Search 40: " + search(40)); // false
    }
}
