import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class blackJack {

    static ArrayList<Integer> playerHand = new ArrayList<>();
    static ArrayList<Integer> dealerHand = new ArrayList<>();


    static int playerSum = 0;
    static int playerAces = 0;

    static int dealerSum = 0;
    static int dealerAces = 0;

    static int newPlayerCard;
    static int newDealerCard;

    public static void main (String [] args) {
        Scanner Input = new Scanner(System.in);

        int money = Main.money ;
        int bet;


        //delete this before final code
        money = 100;



        String choice;
        boolean betting =  true;
        boolean playerPlaying = true;
        boolean dealerPlaying = true;
        boolean playing = true;



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

            System.out.println("Aces: " + playerAces);
            System.out.println("hand: " + playerHand);
            System.out.println("Sum: " + playerSum);

            while (playerPlaying) {
                System.out.print("\ndo you want to hit or stay: ");
                choice = Input.nextLine().trim();
                Input.nextLine();
                switch (choice) {
                    case "Hit":
                    case "hit":
                        drawCardPlayer(deck);
                        System.out.println("Aces: " + playerAces);
                        System.out.println("Hand: " + playerHand);
                        System.out.println("Sum: " + playerSum);
                        break;
                    case "Stay":
                    case "stay":
                        playerPlaying = false;
                        break;
                }

            }
            /*
            while (dealerPlaying) {


            }
            */
            System.out.print("\ndo you want to play again: ");
            String playAgain = Input.nextLine();
            Input.nextLine();
            Input.nextLine();
            if (playAgain.equals("no") || playAgain.equals("No")) {playing = false;}

            betting = true;
            playerPlaying = true;
            dealerPlaying = true;
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

        if (newPlayerCard == 11) {playerAces ++;}

        if (playerSum > 21 && playerAces > 0) {
            System.out.println("turning ace to 1");
        }

        if (deck.isEmpty()) {
            deckBuilder();
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

        if (newDealerCard == 11) {dealerAces ++;}

        if (deck.isEmpty()) {
            deckBuilder();
        }
    }
}