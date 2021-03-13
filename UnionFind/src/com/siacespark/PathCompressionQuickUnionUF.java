package com.siacespark;

public class PathCompressionQuickUnionUF implements UF {
    int[] id;
    int[] sz;

    public PathCompressionQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int root_p = root(p), root_q = root(q);
        if (root_p == root_q) return;

        if (sz[root_p] < sz[root_q]) {
            id[root_p] = id[root_q];
            sz[root_q] += sz[root_p];
        } else {
            id[root_q] = id[root_p];
            sz[root_p] += sz[root_q];
        }
    }

    private int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
}
