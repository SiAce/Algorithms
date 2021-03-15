package com.siacespark;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ResizingArrayStackOfStringsTest {
    @Test
    void main() throws FileNotFoundException {
        StackofStrings stack = new ResizingArrayStackOfStrings();

        File input = new File("tobe.txt");
        Scanner scanner = new Scanner(input);

        StringBuilder sb = new StringBuilder();
        String SEPARATOR = "";

        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("-")) {
                sb.append(SEPARATOR);
                sb.append(stack.pop());
                SEPARATOR = " ";
            }
            else stack.push(s);
        }

        String outputStr = sb.toString();

        File output = new File("stack_output.txt");
        scanner = new Scanner(output);

        String sampleOutputStr = scanner.nextLine();

        assertEquals(sampleOutputStr, outputStr);
    }

}
