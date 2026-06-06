class User {
    private final int pin;
    private double balance;
    private final int accountType;

    public User(int pin, int balance, int accountType) {
        this.pin = pin;
        this.balance = balance;
        this.accountType = accountType;
    }

    static void computeInterest(double currentBalance) {
        double res = currentBalance * 0.03;
        System.out.println("Interest earned: " + res);
    }

    public void depositMoney(double amount) {
        this.balance += amount;
        System.out.println("Deposit Successfully!");
        System.out.println("Deposit amount: " + amount + " new balance: " + this.balance);
    }

    public void withdrawMoney(int accountType,double amount) {
        double maxBalanceSavings = 1000; // Minimum balance required for a savings account
        double maxBalanceCurrent = 5000; // Minimum balance required for a current account

        if (accountType == 1) { // Withdrawal for savings account
            if(amount <= 0) {
                System.out.println("Invalid amount. Must be a positive value.");
            }else if(amount > 20000) {
                System.out.println("Withdrawal limit: 20,000 per day.");
            }else if(amount > balance) {
                System.out.println("Invalid amount. Insufficient balance.");
            }else if(balance - amount < maxBalanceSavings) {
                System.out.println("Unable to complete your withdrawal.");
                System.out.println("Your balance cannot fall below the minimum of " + maxBalanceSavings);
            }else {
                this.balance -= amount;
                System.out.println("Withdrawn Successfully!");
                System.out.println("Withdrawn amount: " + amount + " | New balance: " + this.balance);
            }
        }else{ //withdrawal with current account
            if(amount <= 0) {
                System.out.println("Invalid amount. Must be a positive value.");
            }else if(amount > balance) {
                System.out.println("Invalid amount. Insufficient balance.");
            }else if(balance - amount < maxBalanceCurrent) {
                System.out.println("Unable to complete your withdrawal.");
                System.out.println("Your balance cannot fall below the minimum of " + maxBalanceCurrent);
            }else {
                this.balance -= amount;
                System.out.println("Withdrawn Successfully!");
                System.out.println("Withdrawn amount: " + amount + " | New balance: " + this.balance);
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    public int getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return "PIN: " + pin + ", Balance: " + balance + ", Account type: " + accountType;
    }
}
