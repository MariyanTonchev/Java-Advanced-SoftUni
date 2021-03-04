package StackIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomStack stack = new CustomStack();
        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            if (line.equals("Pop")) {
                try {
                    stack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                List<Integer> input = Arrays.stream(line.replace("Push ", "").trim().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toList());
                for (Integer integer : input) {
                    stack.push(integer);
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (Integer o : stack) {
                System.out.println(o);
            }
        }
    }
}
