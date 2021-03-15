package com.siacespark;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ResizingArrayQueueOfStringsTest {
    @Test
    void main() throws FileNotFoundException {
        QueueOfStrings queue = new ResizingArrayQueueOfStrings();

        File input = new File("tobe.txt");
        Scanner scanner = new Scanner(input);

        StringBuilder sb = new StringBuilder();
        String SEPARATOR = "";

        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("-")) {
                sb.append(SEPARATOR);
                sb.append(queue.deQueue());
                SEPARATOR = " ";
            }
            else queue.enQueue(s);
        }

        String outputStr = sb.toString();

        File output = new File("queue_output.txt");
        scanner = new Scanner(output);

        String sampleOutputStr = scanner.nextLine();

        assertEquals(sampleOutputStr, outputStr);
    }
}