package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, BankAccount> accounts = new HashMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String output;
            switch (tokens[0]) {
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if (accounts.containsKey(id)) {
                        accounts.get(id).deposit(amount);
                        output = "Deposited " + amount + " to ID" + id;
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(newInterest);
                    output = null;
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (accounts.containsKey(id)) {
                        double interest = accounts.get(id).getInterestRate(years);
                        output = String.format("%.2f", interest);
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                default:
                    BankAccount bankAccount = new BankAccount();
                    accounts.put(bankAccount.getId(), bankAccount);
                    output = "Account ID" + bankAccount.getId() + " created";
                    break;
            }
            if (output != null) {
                System.out.println(output);
            }
            input = scanner.nextLine();
        }
    }
}