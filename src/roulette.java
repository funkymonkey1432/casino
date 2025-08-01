
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
                System.out.print("Place your bet (number): ");
                wager = scanner.nextInt();


                if (wager > budget) {
                    System.out.println("Insufficient funds");
                } else {
                    System.out.println("Bet successful!");
                    budget -= wager;
                    break;
                }
            }

            System.out.print("parity (odd/even), thirds, number or colours (Type one of the 4 given options): ");
            String choice = scanner.next();
            choice = choice.toLowerCase();

            switch (choice){
                    case "parity":
                        System.out.print("odd or even: ");
                        String parityBet = scanner.next().toLowerCase();
                        System.out.println("The result is: " + result);

                        if (((parityBet.equals("even") && result % 2 == 0 && 0 != result) ||
                            (parityBet.equals("odd") && result % 2 == 1 && 0 != result)) && result!=0) {
                            System.out.println("You win!\nBet: " + wager + "\nPayout: Your bet + " + wager + "$");
                            budget += 2 * wager;
                            System.out.println("Current budget: " + budget + "$");
                        } else if (((parityBet.equals("even") && result % 2 == 1) ||
                                  (parityBet.equals("odd") && result % 2 == 0)) && result!=0){
                            System.out.println("You lose!\nCurrent budget: " + budget + "$");
                        } else if (result == 0) {
                            System.out.println("The house wins. Tough luck!");
                        }else {
                            System.out.println("invalid input");
                        }
                        break;
                    case "number":
                        System.out.print("Chose your number (0-32): ");
                        int numberBet = scanner.nextInt();
                        if (numberBet == result) {
                            budget += 33 * wager;
                            System.out.println("You win!\nBet: " + wager + "$\nPayout: " + (33 * wager) + "$");
                        } else if (result == 0){
                            System.out.println("The house wins. Tough luck!");
                        } else {
                            System.out.println("You lose!\nCurrent budget: " + budget + "$");
                        }
                        break;
                    case "thirds":
                        System.out.print("bottom,mid or top: ");
                        String thirdsBet = scanner.next().toLowerCase();
                        switch (thirdsBet){
                            case "bottom":
                                if (result <= 10) {
                                    System.out.println("You win!\nBet: " + wager + "$\nPayout: " + (2 * wager) + "$");
                                    budget += 2* wager;
                                } else {
                                    System.out.println("You lose!\nCurrent budget: " + budget + "$");
                                }break;

                            case "mid":
                                if (result > 10 && result < 22) {
                                    System.out.println("You win!\nBet: " + wager + "$\nPayout: " + (2 * wager) + "$");
                                    budget+=2*wager;
                                } else {
                                    System.out.println("You lose!\nCurrent budget: " + budget + "$");
                                }break;

                            case "top":
                                if (result > 21) {
                                    System.out.println("You win!\nBet: " + wager + "$\nPayout: " + (2 * wager) + "$");
                                    budget+=2*wager;
                                }else if (result == 0) {
                                    System.out.println("The house wins. Tough luck!");
                                }else {
                                    System.out.println("You lose!\nCurrent budget: " + budget + "$");
                                }break;
                        }
                        break;
                    case "colours":
                        System.out.print("Red or Black: ");
                        String bet = scanner.next();
                        bet = bet.toLowerCase();
                        System.out.println(bet);
                        System.out.println("Its a "+rouletteTable.get(result)+" "+result+".");
                        if ((rouletteTable.get(result).equals("red") && bet.equals("red")) || (rouletteTable.get(result).equals("black") && bet.equals("black"))){
                            System.out.println("You win!\nBet: " + wager + "\nPayout: Your bet + " + wager + "$");
                            budget+=2*wager;
                        }else if (result == 0) {
                            System.out.println("The house wins. Tough luck!");
                        }else{
                            System.out.println("You lose!\nCurrent budget: " + budget + "$");
                        }
                        break;
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