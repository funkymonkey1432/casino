import java.util.Scanner;
import java.util.Random;

public class rockPaperScissors {
    public static void main(String[] args) {

        System.out.println("You're playing rock paper scissors in a casino? weird");

        while (true) {

            Random random = new Random();
            Scanner scanner = new Scanner(System.in);
            String[] botChoices = {"rock", "paper", "scissors"};
            double bet;
            String choice;
            String botChoice;
            String continueChoice;

            System.out.println("You have $" + Main.money + ".");
            System.out.print("How much money are you betting: $");
            bet = scanner.nextDouble();
            scanner.nextLine();
            Main.money -= bet;

            System.out.print("rock, paper or scissors: ");
            choice = scanner.nextLine();
            botChoice = botChoices[random.nextInt(2)];
            if (botChoice.equals(choice)) {
                System.out.println("Dealer shows " + botChoice + ".");
                System.out.println("It's a draw!");
                Main.money += bet;
            } else if ((botChoice.equals("rock") && choice.equals("paper")) ||
                    (botChoice.equals("paper") && choice.equals("scissors")) ||
                    (botChoice.equals("scissors") && choice.equals("rock"))) {
                System.out.println("Dealer shows " + botChoice + ".");
                System.out.println("You win!");
                System.out.println("Payout $" + (1.5 * bet) + ".");
                Main.money += 1.5 * bet;
            } else {
                System.out.println("Dealer shows " + botChoice + ".");
                System.out.println("You lose!");
            }
            System.out.print("Do you want to keep playing? yes or no: ");
            continueChoice = scanner.nextLine();
            switch (continueChoice){
                case "yes":
                    break;
                case "no":
                    return;

            }
        }
    }
}