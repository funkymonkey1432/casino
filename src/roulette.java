//TODO: ben put all the win and lose statements together and make everything a switch case
import java.util.*;

public class roulette {

    static int budget = Main.money;
    static int [] reds = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32};
    static Map<Integer, String> rouletteTable = new HashMap<>();

    public static void main(String[] args){

        sortColours();

        while (true) {

            Scanner scanner = new Scanner(System.in);

            Random number = new Random();
            int result;
            int wager;

            result = number.nextInt(33);


            System.out.println("\nStarting budget: " + budget + "$");

            while (true) {
                System.out.print("Place your bet: ");
                wager = scanner.nextInt();


                if (wager > budget) {
                    System.out.println("Insufficient funds");
                } else {
                    System.out.println("Bet successful!");
                    budget -= wager;
                    break;
                }
            }

            System.out.print("parity (odd/even), thirds, a number or colours (Type one of the 4 given options): ");
            String choice = scanner.next();
            choice = choice.toLowerCase();
            if (choice.equals("parity")) {
                System.out.print("odd or even: ");
                String bet = scanner.next().toLowerCase();
                System.out.println("The result is: " + result);

                if ((bet.equals("even") && result % 2 == 0 && 0 != result) ||
                    (bet.equals("odd") && result % 2 == 1 && 0 != result)) {
                    System.out.println("You win!\nBet: " + wager + "\nPayout: Your bet + " + wager + "$");
                    budget += 2 * wager;
                    System.out.println("Current budget: " + budget + "$");
                } else if ((bet.equals("even") && result % 2 == 1) ||
                          (bet.equals("odd") && result % 2 == 0)){
                    System.out.println("You lose!\nCurrent budget: " + budget + "$");
                } else {
                    System.out.println("invalid input");
                }

            } else if (choice.equals("number")) {
                System.out.print("Chose your number (0-32): ");
                int bet = scanner.nextInt();
                if (bet == result) {
                    budget += 33 * wager;
                    System.out.println("You win!\nBet: " + wager + "$\nPayout: " + (33 * wager) + "$");
                } else {
                    System.out.println("You lose!\nCurrent budget: " + budget + "$");
                }

            } else if (choice.equals("thirds")) {
                System.out.print("bottom,mid or top: ");
                String thirdsChoice = scanner.next().toLowerCase();
                if (thirdsChoice.equals("bottom")) {
                    if (result <= 10) {
                        System.out.println("You win!\nBet: " + wager + "$\nPayout: " + (2 * wager) + "$");
                        budget += 2* wager;
                    } else {
                        System.out.println("You lose!\nCurrent budget: " + budget + "$");
                    }
                }
                if (thirdsChoice.equals("mid")) {
                    if (result > 10 && result < 22) {
                        System.out.println("You win!\nBet: " + wager + "$\nPayout: " + (2 * wager) + "$");
                        budget+=2*wager;
                    } else {
                        System.out.println("You lose!\nCurrent budget: " + budget + "$");
                    }
                }
                if (thirdsChoice.equals("top")) {
                    if (result > 21) {
                        System.out.println("You win!\nBet: " + wager + "$\nPayout: " + (2 * wager) + "$");
                        budget+=2*wager;
                    } else {
                        System.out.println("You lose!\nCurrent budget: " + budget + "$");
                    }
                }
            }else if (choice.equals("colours")){
                System.out.print("Red or Black: ");
                String bet = scanner.next();
                bet = bet.toLowerCase();
                System.out.println(bet);
                System.out.println("Its a "+rouletteTable.get(result)+" "+result+".");
                if ((rouletteTable.get(result).equals("red") && bet.equals("red")) || (rouletteTable.get(result).equals("black") && bet.equals("black"))){
                    System.out.println("You win!\nBet: " + wager + "\nPayout: Your bet + " + wager + "$");
                    budget+=2*wager;
                }else{
                    System.out.println("You lose!\nCurrent budget: " + budget + "$");
                }
            }
            System.out.print("Do you want to continue? yes or no:  ");
            String keepGoing = scanner.next();

            if (keepGoing.equals("no")){
                Main.money = budget;

                break;
            }else if (budget<=0){
                System.out.println("Sorry, but you're all out of cash!");
                Main.money = budget;
                break;
            }

        }
    }
    private static void sortColours(){

        rouletteTable.put(0, "green");

        for (int i = 0; i<33; i++) {
            if (containsInteger.contains(reds, i)) {
                rouletteTable.put(i, "red");
            } else {
                rouletteTable.put(i, "black");
            }
        }
    }
}