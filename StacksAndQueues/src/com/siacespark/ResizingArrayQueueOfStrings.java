package com.siacespark;

public class ResizingArrayQueueOfStrings implements QueueOfStrings {
    private String[] s;
    private int first = 0;
    private int last = 0;

    public ResizingArrayQueueOfStrings() {
        s = new String[1];
    }

    @Override
    public void enQueue(String item) {
        if (size() >= s.length - 1) resize(2 * s.length);
        int oldSize = size();
        s[last] = item;
        last = (last + 1) % s.length;
    }

    @Override
    public String deQueue() {
        String item = s[first];
        s[first] = null;
        first = (first + 1) % s.length;

        if (size() > 0 && size() <= s.length / 4) resize(s.length / 2);

        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == last;
    }

    @Override
    public int size() {
        return (last - first + s.length) % s.length;
    }

    private void resize(int capacity) {
        String[] new_s = new String[capacity];
        int j = first;
        int i = 0;

        for (; i < size(); i++){
            new_s[i] = s[j];
            j = (j + 1) % s.length;
        }

        s = new_s;
        first = 0;
        last = i;
    }

    private class Node {
        String item;
        Node next;
    }
}
