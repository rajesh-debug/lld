package com.cache.core.data;

/**
 * A doubly linked list with non-contiguous memory allocation.
 * Supports bidirectional traversal from a known node, but does not support index-based access.
 *
 * @param <E> Type of elements stored in the list.
 */
public class DoublyLinkedList<E> {

    private final DoublyLinkedListNode<E> dummyHead;
    private final DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList() {
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    /**
     * Detaches a node from the list. The node is not deleted, but becomes orphaned.
     *
     * @param node Node to be detached.
     */
    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node != null && node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    /**
     * Adds a node at the end of the list (before the dummy tail).
     *
     * @param node Node to be added.
     */
    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        if (node == null) {
            throw new RuntimeException("Invalid element exception");
        }

        DoublyLinkedListNode<E> lastNode = dummyTail.prev;

        lastNode.next = node;
        node.prev = lastNode;

        node.next = dummyTail;
        dummyTail.prev = node;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param element Element to add.
     * @return Newly created node containing the element.
     */
    public DoublyLinkedListNode<E> addElementAtLast(E element) {
        if (element == null) {
            throw new RuntimeException("Invalid element exception");
        }

        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    /**
     * Checks whether the list has any actual elements.
     *
     * @return true if there are elements; false otherwise.
     */
    public boolean isNotEmpty() {
        return dummyHead.next != dummyTail;
    }

    /**
     * Returns the first actual node (after the dummy head).
     *
     * @return First node in the list, or null if the list is empty.
     */
    public DoublyLinkedListNode<E> getFirstNode() {
        return isNotEmpty() ? dummyHead.next : null;
    }

    /**
     * Returns the last actual node (before the dummy tail).
     *
     * @return Last node in the list, or null if the list is empty.
     */
    public DoublyLinkedListNode<E> getLastNode() {
        return isNotEmpty() ? dummyTail.prev : null;
    }
}
