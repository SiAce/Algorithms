package com.siacespark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        UF uf = new PathCompressionQuickUnionUF(N);

        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
