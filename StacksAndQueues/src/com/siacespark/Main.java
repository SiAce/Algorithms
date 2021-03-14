package com.siacespark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StackofStrings stack = new FixedArrayStackofStrings(10);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("-")) System.out.println(stack.pop());
            else stack.push(s);
        }
    }
}
