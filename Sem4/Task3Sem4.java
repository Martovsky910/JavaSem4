package Sem4;

import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Task3Sem4 {
    static Stack<String> inputHistory = new Stack<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (inputHistory.size() % 2 == 0) {
                System.out.println("Введи число");
                String input = scanner.nextLine();
                if (input.equals("Cancel")) {
                    inputHistory.pop();
                    inputHistory.pop();
                    printOps();
                    continue;
                }
                if (!input.matches("-?\\d+")) {
                    System.out.println("Я попросил число");
                    continue;
                } else {
                    inputHistory.push(input);
                }
            } else {
                System.out.println("Введи оператор");
                String input = scanner.nextLine();
                if (input.equals("Cancel")) {
                    inputHistory.pop();
                    inputHistory.pop();
                    printOps();
                    continue;
                }
                if (!input.equals("+") && !input.equals("-") && !input.equals("*") && !input.equals("/")) {
                    System.out.println("я же попросил оператор");
                } else {
                    inputHistory.push(input);
                }
                continue;
            }
            if (inputHistory.size() > 2 && inputHistory.size() % 2 == 1) {
                printOps();
                calculateAndShowResult();
            }
        }
    }

    private static void printOps() {
        List<String> inputs = new ArrayList<String>(inputHistory);
        System.out.println("Текущие операции: " + String.join(" ", inputs));
    }

    static void calculateAndShowResult() {
        List<String> inputCopy = new ArrayList<String>(inputHistory);
        int result = Integer.parseInt(inputCopy.get(0));
        int currentPair = 1;
        while (currentPair * 2 + 1 <= inputCopy.size()) {
            int number = Integer.parseInt(inputCopy.get(currentPair * 2));
            String oper = inputCopy.get(currentPair * 2 - 1);
            switch (oper) {
                case "+": {
                    result += number;
                    break;
                }
                case "-": {
                    result -= number;
                }
                case "*":{
                    result *= number;
                }
                case "/":{
                    result /= number;
                }
            }
            currentPair++;
        }
        System.out.println(">>>>> Итого сейчас " + result);
    }
}