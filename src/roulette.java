import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class roulette {
    public static void main(String[] args){

        int budget;
        int [] reds = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32};


        budget = 100;

        Map<Integer, String> rouletteTable = new HashMap<>();

        rouletteTable.put(0, "green");

        for (int i = 0; i<33; i++){
            if (containsInteger.contains(reds, i)){
                rouletteTable.put(i,"red");
            }else{
                rouletteTable.put(i, "black");
            }
        }

        while (true) {

            Scanner scanner = new Scanner(System.in);

            Random number = new Random();
            int result;

            int wager;

            result = number.nextInt(33);


            System.out.println("Starting budget: " + budget + "$");

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

            System.out.print("odd/even, thirds, a number or red/black: ");

            String choice = scanner.next();
            if (choice.equals("odd/even")) {
                System.out.print("Odd or Even: ");
                String bet = scanner.next();
                System.out.println("The result is: " + result);
                if (bet.equals("Even") && result % 2 == 0 && 0 != result) {
                    System.out.println("You win!\n Bet: " + wager + "\nPayout: Your bet + " + wager + "$");
                    budget = budget + 2 * wager;
                    System.out.println("Current budget: " + budget + "$");
                } else if (bet.equals("Odd") && result % 2 == 1 && 0 != result) {
                    System.out.println("You win!\n Bet: " + wager + "$\nPayout: Your bet + " + wager + "$");
                    budget = budget + 2 * wager;
                    System.out.println("Current budget: " + budget + "$");
                } else if (bet.equals("Even") && result % 2 == 1) {
                    System.out.println("You lose!\nCurrent budget: " + budget + "$");
                } else if (bet.equals("Odd") && result % 2 == 0) {
                    System.out.println("You lose!\nCurrent budget: " + budget + "$");
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
                System.out.print("bottom,mid or top third: ");
                String thirdsChoice = scanner.next();
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
            }else if (choice.equals("red/black")){
                System.out.print("Red or Black: ");
                String bet = scanner.next();
                if (rouletteTable.get(result).equals("Red")){
                    System.out.println("You win!\n Bet: " + wager + "\nPayout: Your bet + " + wager + "$");
                    budget+=2*wager;
                }else{
                    System.out.println("You lose!\nCurrent budget: " + budget + "$");
                }
            }



            System.out.print("Do you want to continue? yes or no:  ");
            String keepGoing = scanner.next();

            if (keepGoing.equals("no")){
                break;
            }else if (budget<=0){
                System.out.println("Sorry, but you're all out of cash!");
                break;
            }else{

            }

        }
    }
}