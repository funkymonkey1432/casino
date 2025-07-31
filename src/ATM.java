import java.util.Scanner;


public class ATM {
    public static void main (String [] args) {
        String name = Main.name;
        int bankAccount = Main.bankAccount;

        Scanner input = new Scanner(System.in);
        primaryAccount parentAccount = new primaryAccount(name, bankAccount);

        while (true) {
            System.out.println("\n--- bank Account Options ---");
            System.out.println("1. deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. check balance");
            System.out.println("4. exit");
            System.out.println("chose a option 1-4: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("inter a amount to deposit");
                    double depositAmount = input.nextDouble();
                    input.nextLine();
                    parentAccount.deposit(depositAmount);
                    break;
                case "2":
                    System.out.println("inter a amount to withdraw");
                    double withdrawAmount = input.nextDouble();
                    input.nextLine();
                    parentAccount.withdraw(withdrawAmount);
                    break;
                case "3":
                    parentAccount.checkBalance();
                    break;
                case "4":
                    System.out.println("exiting ATM");
                    input.close();
                    return;
                default:
                    System.out.println("invalid  option");

            }
        }
    }



    static class primaryAccount {
        int money = Main.money;

        public String name;
        public double balance;

        public primaryAccount(String name, int balance) {
            this.name = name;
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount >= 0 && amount < money) {
                money -= amount;
                this.balance += amount;
                System.out.println("Deposited $" + amount + " your new balance is " + this.balance);
            } else {
                System.out.println("invalid amount");
            }
        }

        public void withdraw(double amount) {
            if (amount >= 0 && amount <= this.balance) {
                money += amount;
                this.balance -= amount;
                System.out.println("WithDrew $" + amount + " your new balance is " + this.balance);
            } else {
                System.out.println("invalid amount");
            }
        }

        public void checkBalance () {
            System.out.println("current balance: $" + this.balance);
        }
    }

}
