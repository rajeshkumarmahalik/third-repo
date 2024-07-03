import java.util.Scanner;
    class BankAccount {
        private double balance;
        public BankAccount(double initialBalance) {balance = initialBalance;}
        public double getBalance() {return balance;}
        public void deposit(double amount) { balance += amount;}
        public boolean withdraw(double amount) {
            if (amount <= balance) {balance -= amount;
                return true;
            }
            return false;
        }
    }
    class ATM {
        private BankAccount account;
        public ATM(BankAccount bankAccount) {
            account = bankAccount;
        }
        public void displayMenu() {
            System.out.println(" ATM Bank:");
            System.out.println(" Check Balance");
            System.out.println(" Deposit");
            System.out.println(" Withdraw");
            System.out.println(" Exit");
        }
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenu();
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Your balance: Rs. " + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful. Your balance: Rs. " + account.getBalance());
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        if (account.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful. Your balance: Rs. " + account.getBalance());
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        return;
                }
            }
        }
    }
    public class AtmInterface {
        public static void main(String[] args) {
            BankAccount userAccount = new BankAccount(5000);
            ATM atm = new ATM(userAccount);
            atm.run();
        }
    }
