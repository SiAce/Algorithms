package com.siacespark;

public class ListQueueOfStrings implements QueueOfStrings {
    private Node first = null;
    private Node last = null;

    @Override
    public void enQueue(String item) {
        Node node = new Node();
        node.item = item;

        if (isEmpty()) first = node;
        else last.next = node;

        last = node;
    }

    @Override
    public String deQueue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        Node node = first;
        int length = 0;

        while (node != last) {
            node = node.next;
            length++;
        }

        return length;
    }

    private class Node {
        String item;
        Node next;
    }
}
