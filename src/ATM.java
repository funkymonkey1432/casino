import java.util.Scanner;


public class ATM {

    static int loanAmount;

    public static void main (String [] args) {
        String name = Main.name;
        int bankAccount = Main.bankAccount;

        Scanner input = new Scanner(System.in);
        primaryAccount parentAccount = new primaryAccount(name, bankAccount);

        while (true) {
            System.out.println("\n--- bank Account Options ---");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.println("4. Take out a loan");
            System.out.println("5. Pay off a loan");
            System.out.println("6. Exit");
            System.out.print("chose a option 1-6: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("inter a amount to deposit: ");
                    int depositAmount = input.nextInt();
                    input.nextLine();
                    parentAccount.deposit(depositAmount);
                }
                case "2" -> {
                    System.out.println("you have $" + parentAccount.balance);
                    System.out.print("enter an amount to withdraw: ");
                    int withdrawAmount = input.nextInt();
                    input.nextLine();
                    parentAccount.withdraw(withdrawAmount);
                }
                case "3" -> parentAccount.checkBalance();
                case "4" -> {
                    System.out.print("enter an amount for your loan: ");
                    loanAmount = input.nextInt();
                    input.nextLine();
                    if (loanAmount > 0) {
                        parentAccount.money += loanAmount;
                    }
                }
                case "5" -> {
                    if (loanAmount!=0 && Main.money!=0){
                        System.out.print("Current loan debt: $"+loanAmount+"\nCash in hand: $"+Main.money+"\nthe amount you want to pay off: ");
                        int loanPayoffAmount = input.nextInt();
                        input.nextLine();
                        loanAmount-=loanPayoffAmount;
                        parentAccount.money -= loanPayoffAmount;
                        System.out.println("\nNew loan amount: $"+loanAmount);
                    }else if (Main.money==0){
                        System.out.println("you can only pay cash.\ncurrent cash amount: $"+Main.money);
                    }
                    else{
                        System.out.println("No loans to pay off.");
                    }
                }
                case "6" -> {
                    Main.bankAccount = (int) parentAccount.balance;
                    Main.money = parentAccount.money;
                    System.out.println("Exiting ATM with $"+Main.money+" in hand.");
                    return;
                }
                default -> {System.out.println("invalid  option");}
            }
        }
    }



    static class primaryAccount {
        int money = Main.money;

        public String name;
        public int balance;

        public primaryAccount(String name, int balance) {
            this.name = name;
            this.balance = balance;
        }

        public void deposit(int amount) {
            if (amount >= 0 && amount <= money) {
                money -= amount;
                this.balance += amount;
                System.out.println("Deposited $" + amount + " your new balance is $" + this.balance);
            } else {
                System.out.println("invalid amount");
            }
        }

        public void withdraw(int amount) {
            if (amount >= 0 && amount <= this.balance) {
                money += amount;
                this.balance -= amount;
                System.out.println("WithDrew $" + amount + " your new balance is $ " + this.balance);
            } else {
                System.out.println("invalid amount");
            }
        }

        public void checkBalance () {
            System.out.print("current balance: $" + this.balance+"\nloans to pay off: $" + loanAmount + "\n");
        }
    }

}
