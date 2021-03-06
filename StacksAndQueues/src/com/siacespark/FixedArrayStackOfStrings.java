package com.siacespark;

public class FixedArrayStackOfStrings implements StackofStrings {
    private String[] s;
    private int N = 0;

    public FixedArrayStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void push(String item) {
        s[N++] = item;
    }

    @Override
    public String pop() {
        return s[--N];
    }
}
