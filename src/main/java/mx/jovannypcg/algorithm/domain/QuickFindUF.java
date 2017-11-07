package mx.jovannypcg.algorithm.domain;

import java.util.Arrays;

public class QuickFindUF {
    private int [] id;

    public QuickFindUF(int n) {
        id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int idSize() {
        return id.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(id).forEach(item -> sb.append(item).append(" "));

        return sb.toString();
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    // Quick implementation =============================

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }

        return i;
    }

    public boolean quickConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void quickUnion(int p, int q) {
        int i = root(p);
        int j = root(q);

        id[i] = j;
    }
}
