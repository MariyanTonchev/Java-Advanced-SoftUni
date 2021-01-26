import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> numbersQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        String[] tokens = input.split("\\s+");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0)) || Character.isLetter(token.charAt(0))) {
                numbersQueue.offer(token);
            } else {
                if (operatorsStack.isEmpty()) {
                    operatorsStack.push(token);
                } else {
                    String lastOperator = operatorsStack.peek();
                    switch (token) {
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")) {
                                operatorsStack.push(token);
                            } else {
                                numbersQueue.offer(operatorsStack.pop());
                                operatorsStack.push(token);
                            }
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                numbersQueue.offer(operatorsStack.pop());
                                operatorsStack.push(token);
                            } else {
                                operatorsStack.push(token);
                            }
                            break;
                        case "(":
                            operatorsStack.push(token);
                            break;
                        case ")":
                            while (!operatorsStack.peek().equals("(")) {
                                numbersQueue.offer(operatorsStack.pop());
                            }
                            operatorsStack.pop();
                            break;
                    }
                }
            }
        }
        while (!numbersQueue.isEmpty()) {
            System.out.print(numbersQueue.poll() + " ");
        }
        while (!operatorsStack.isEmpty()) {
            System.out.print(operatorsStack.pop() + " ");
        }
    }
}