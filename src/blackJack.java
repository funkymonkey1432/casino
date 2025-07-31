import java.util.Random;
import java.util.Scanner;

public class blackJack {
    public static void main (String [] args) {

        int money = Main.money ;

        Scanner playerInput = new Scanner(System.in);

        /*
        ===========================
                betting
        ===========================
        */

        int bet;
        int newBet = 0;
        boolean betConferm = false;
        boolean bubble = true;

        while (money > 0 || bubble) {

            System.out.println("\n\nbetting:");

            while (!betConferm) {
                System.out.println("you have " + money + " money");
                System.out.println("how much would you like to bet: ");
                newBet = Integer.parseInt(playerInput.nextLine());
                if (newBet <= money) {betConferm = true;}
            }
            bet = newBet;
            betConferm = false;
            money -= bet;

            Random generator = new Random();
            int dealerHand = 0;
            int newDealerCard;
            int dealerAces = 0;
            int newDealerCardPosition;
            boolean dealerHit = true;

            int playerHand = 0;
            int newPlayerCard;
            int playerAces = 0;
            int newPlayerCardPosition;
            boolean playerHit = true;

            String whoWon;

            int[] deck = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

            newDealerCardPosition = generator.nextInt(deck.length);
            newDealerCard = deck[newDealerCardPosition];
            dealerHand += newDealerCard;
            if (newDealerCard == 11) {
                dealerAces++;
            }

            newPlayerCardPosition = generator.nextInt(deck.length);
            newPlayerCard = deck[newPlayerCardPosition];
            playerHand += newPlayerCard;
            if (newPlayerCard == 11) {
                playerAces++;
            }

            newPlayerCardPosition = generator.nextInt(deck.length);
            newPlayerCard = deck[newPlayerCardPosition];
            playerHand += newPlayerCard;
            if (newPlayerCard == 11) {
                playerAces++;
            }
            /*
            ==============================================
                            players turn
            ===============================================
             */
            System.out.println("players turn:\n" + "your first card was a " + (playerHand - newPlayerCard) + "\nyour second card was a " + newPlayerCard);


            if (playerHand > 21 && playerAces > 1) {
                System.out.println("turning ace to 1");
                playerAces--;
                playerHand = playerHand - 10;
            }
            System.out.println("\ndealer shows " + dealerHand + "\n");
            while (playerHit) {

                if (playerHand > 21 && playerAces == 1) {
                    System.out.println("turning ace to 1");
                    playerAces--;
                    playerHand = playerHand - 10;
                }

                System.out.println("hand sum is " + playerHand + ".");
                System.out.println("you have " + playerAces + " aces");
                System.out.println("do you want to Hit or Stay: ");
                String userInput = playerInput.nextLine();
                if (userInput.equals("hit") || userInput.equals("Hit")) {

                    newPlayerCardPosition = generator.nextInt(deck.length);
                    newPlayerCard = deck[newPlayerCardPosition];
                    playerHand += newPlayerCard;
                    if (newPlayerCard == 11) {
                        playerAces++;
                    }

                    System.out.println("your new card is a: " + newPlayerCard);
                } else if (userInput.equals("stay") || userInput.equals("Stay")) {
                    playerHit = false;
                }

                if (playerHand > 21 && playerAces == 0) {
                    System.out.println("player hand total " + playerHand);
                    System.out.println("you busted");
                    playerHit = false;
                    playerHand = 0;
                }
                while (playerHand > 21 && playerAces > 1) {
                    System.out.println("turning ace to 1");
                    playerAces--;
                    playerHand = playerHand - 10;
                    System.out.println("your new total is " + playerHand);
                }
            }
            System.out.println("\ndealers turn: ");

            /*
            =================================================================
                                     dealer turn
            =================================================================
             */
            newDealerCardPosition = generator.nextInt(deck.length);
            newDealerCard = deck[newDealerCardPosition];
            dealerHand += newDealerCard;
            if (newDealerCard == 11) {
                dealerAces++;
            }

            if (dealerHand >= 17) {
                dealerHit = false;
                System.out.println("dealer stays: \n ");
            }

            System.out.println("dealers hole card is a " + newDealerCard + "\ndealers total is " + dealerHand);

            if (dealerHand > 21 && dealerAces > 0) {
                dealerHand -= 10;
                dealerAces--;
                System.out.println("turning a dealer ace to 1");
                System.out.println("dealer new total: " + dealerHand);
            }
            while (dealerHit) {
                if (dealerHand > 21 && dealerAces > 1) {
                    System.out.println("turning ace to 1");
                    dealerAces--;
                    dealerHand -= 10;
                }

                if (dealerHand <= 17) {
                    newDealerCardPosition = generator.nextInt(deck.length);
                    newDealerCard = deck[newDealerCardPosition];
                    dealerHand += newDealerCard;
                    if (newDealerCard == 11) {
                        dealerAces++;
                    }

                    System.out.println("\ndealer hits and gets a " + newDealerCard);
                    System.out.println("dealers total is " + dealerHand);
                }
                if (dealerHand > 21 && dealerAces == 0) {
                    System.out.println("dealer busted");
                    dealerHit = false;
                    dealerHand = 1;
                }
                else if (dealerHand > 17 && dealerAces == 0) {
                    dealerHit = false;
                }
                else if (dealerHand > 21 && dealerAces > 0) {
                    dealerHand -= 10;
                    dealerAces --;
                    System.out.println("turning a dealer ace to 1");
                    System.out.println("dealer new total: " + dealerHand);
                }
            }
            if (dealerHand < playerHand) {
                whoWon = "the player won";
                money += bet * 2;
            } else if (dealerHand > playerHand) {
                whoWon = "the dealer won";
            } else {
                whoWon = "it was a tie";
                money += bet;
            }
            System.out.println("\n" + whoWon);

            System.out.print("do you like to play again: ");
            boolean flamingo = (playerInput.nextLine() == ("no"));

            if (flamingo) {
                Main.money = money;
                bubble = false;
            }
        }
    }
}