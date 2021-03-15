package com.siacespark;

public interface QueueOfStrings {
    void enQueue(String item);

    String deQueue();

    boolean isEmpty();

    int size();
}
