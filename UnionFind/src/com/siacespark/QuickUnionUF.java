package com.siacespark;

public class QuickUnionUF implements UF {
    int[] id;
    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        while (p != id[p]) p = id[p];
        while (q != id[q]) q = id[q];

        return p == q;
    }

    @Override
    public void union(int p, int q) {
        while (p != id[p]) p = id[p];
        while (q != id[q]) q = id[q];

        id[p] = q;
    }
}
