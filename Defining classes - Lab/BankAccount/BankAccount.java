package BankAccount;

class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    BankAccount() {
        this.id = bankAccountCount++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    void deposit(double amount){
        this.balance += amount;
    }

    double getInterestRate(int years) {
        return BankAccount.interestRate * years * this.balance;
    }
}
