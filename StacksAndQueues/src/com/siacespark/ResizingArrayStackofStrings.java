package com.siacespark;

public class ResizingArrayStackofStrings implements StackofStrings {
    private String[] s;
    private int N = 0;

    public ResizingArrayStackofStrings() {
        s = new String[1];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void push(String item) {
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    @Override
    public String pop() {
        String item = s[--N];
        s[N] = null;

        if (N > 0 && N <= s.length / 4) resize(s.length / 2);

        return item;
    }

    private void resize(int capacity) {
        String[] new_s = new String[capacity];

        for (int i = 0; i < N; i++) new_s[i] = s[i];

        s = new_s;
    }
}
