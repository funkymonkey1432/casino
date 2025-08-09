import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class blackJack {

    static ArrayList<Integer> playerHand = new ArrayList<>();
    static ArrayList<Integer> dealerHand = new ArrayList<>();

    static ArrayList<Integer> playerAces = new ArrayList<>();
    static ArrayList<Integer> dealerAces = new ArrayList<>();


    static int playerSum = 0;

    static int dealerSum = 0;

    static int newPlayerCard;
    static int newDealerCard;

    public static void main (String [] args) {
        Scanner Input = new Scanner(System.in);

        int money = Main.money ;
        int bet = 0;


        //delete this before final code
        money = 100;



        String choice;
        boolean betting =  true;
        boolean playerPlaying = true;
        boolean dealerPlaying = true;
        boolean playing = true;

        boolean playerBusted = false;
        boolean dealerBusted = false;

        while (playing) {
            while (betting) {
                System.out.print("how much do you want to bet: ");
                bet = Input.nextInt();
                Input.nextLine();
                if (bet > money || bet < 0) {
                    System.out.println("invalid option Try again");
                } else {betting = false;}
            }

            ArrayList<Integer> deck = deckBuilder();

            //draws the players starting cards
            drawCardPlayer(deck);
            drawCardPlayer(deck);

            //draws the dealers starting cards
            drawCardDealer(deck);

            System.out.println("dealer shows: " + newDealerCard + "\n");

            drawCardDealer(deck);

            System.out.println("Aces: " + playerAces.size());
            System.out.println("hand: " + playerHand);
            System.out.println("Sum: " + playerSum);

            while (playerPlaying) {
                System.out.print("\ndo you want to hit or stay: ");
                choice = Input.nextLine().trim();

                switch (choice) {
                    case "Hit":
                    case "hit":
                        drawCardPlayer(deck);
                        System.out.println("Aces: " + playerAces.size());
                        System.out.println("Hand: " + playerHand);
                        System.out.println("Sum: " + playerSum);
                        break;
                    case "Stay":
                    case "stay":
                        playerPlaying = false;
                        break;
                }

                if (playerSum > 21) {
                    System.out.println("you busted");
                    playerPlaying = false;
                    playerBusted = true;
                }

            }
            System.out.println("dealers hole card is " + newDealerCard);
            System.out.println("dealers total is " + dealerSum);
            while (dealerPlaying) {
                if (dealerSum < 17) {
                    drawCardDealer(deck);
                    System.out.println("\ndealer draws a " + newDealerCard + "\ndealers new total is " + dealerSum);
                }
                if (dealerSum > 21) {
                    System.out.println("dealer busted");
                    dealerPlaying = false;
                    dealerBusted = true;
                }
                if (dealerSum > 17 && dealerSum < 21) {
                    System.out.println("dealer stays");
                    dealerPlaying = false;
                }


            }

            if (playerBusted && dealerBusted) {
                System.out.println("you both busted \nyou lose :(");
            } else if (playerSum > dealerSum) {
                System.out.println("you had a higher sum \nyou win!");
                money += (bet * 2);
            }else if (dealerSum > playerSum) {
                System.out.println("the dealer had a higher sum \nyou lose :(");
            }else {
                System.out.println("your sums are the same \nyou tie");
                money += bet;
            }
            bet = 0;

            while (!playerHand.isEmpty()) {
                playerHand.remove(0);
            }
            while (!dealerHand.isEmpty()) {
                dealerHand.remove(0);
            }
            System.out.print("\ndo you want to play again: ");
            String playAgain = Input.nextLine();
            if (playAgain.equals("no") || playAgain.equals("No")) {playing = false;}

            betting = true;
            playerPlaying = true;
            dealerPlaying = true;

            playerAces.clear();
            dealerAces.clear();
            playerSum = dealerSum = 0;
            playerBusted = dealerBusted = false;

        }
    }


    public static ArrayList<Integer> deckBuilder () {
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            int value = (i % 13) + 1;
            if (value <= 10 && value != 1) {
                deck.add(value);
            }else if (value == 1) {
                deck.add(11);
            }else {
                deck.add(10);
            }
        }
        return deck;
    }

    public static void drawCardPlayer(ArrayList<Integer> deck) {
        Random random = new Random();
        int randomNumber = random.nextInt(deck.size());

        newPlayerCard = deck.get(randomNumber);
        deck.remove(randomNumber);

        System.out.println("you drew a " + newPlayerCard);
        playerHand.add(newPlayerCard);

        playerSum = 0;
        for (int card : playerHand) {
            playerSum += card;
        }

        if (newPlayerCard == 11) {playerAces.add(playerHand.size()-1);}

        if (playerSum > 21 && !playerAces.isEmpty()) {
            System.out.println("turning ace to 1");
            playerHand.set(playerAces.get(0), 1);
            playerAces.remove(0);
        }

        if (deck.isEmpty()) {
            deckBuilder();
        }

        playerSum = 0;
        for (int card : playerHand) {
            playerSum += card;
        }

    }

    public static void drawCardDealer(ArrayList<Integer> deck) {
        Random random = new Random();
        int randomNumber = random.nextInt(deck.size());

        newDealerCard = deck.get(randomNumber);
        deck.remove(randomNumber);

        dealerHand.add(newDealerCard);

        dealerSum = 0;
        for (int card : dealerHand) {
            dealerSum += card;
        }

        if (newDealerCard == 11) {dealerAces.add(dealerHand.size() - 1);}

        if (dealerSum > 21 && !dealerAces.isEmpty()) {
            System.out.println("turning ace to 1");
            dealerHand.set(dealerAces.get(0), 1);
            dealerAces.remove(0);
        }

        if (deck.isEmpty()) {
            deck.addAll(deckBuilder());
        }

        dealerSum = 0;
        for (int card : dealerHand) {
            dealerSum += card;
        }

    }
}