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
        Random random = new Random();
        Scanner Input = new Scanner(System.in);

        int money = Main.money ;
        int bet = 0;

        money = 100;

        boolean betting =  true;
        boolean playerPlaying = true;
        boolean dealerPlaying = true;
        boolean playing = true;



        while (playing) {
            while (betting) {
                System.out.print("how much do you want to bet: ");
                bet = Input.nextInt();
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
            /*
            while (playerPlaying) {


            }

            while (dealerPlaying) {


            }
            */
            System.out.print("do you want to play again: ");
            String playAgain = Input.nextLine();
            Input.nextLine();
            if (playAgain.equals("no") || playAgain.equals("No")) {playing = false;}
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

    public static Integer drawCardPlayer(ArrayList<Integer> deck) {
        Random random = new Random();
        int randomNumber = random.nextInt(deck.size());

        newPlayerCard = deck.get(randomNumber);
        deck.remove(randomNumber);

        System.out.println("you drew a " + newPlayerCard);
        playerHand.add(newPlayerCard);

        for (int i = 0; 1 < (playerHand.size() - 1); i++) {
            playerSum += playerHand.get(i);
        }

        if (newPlayerCard == 11) {playerAces ++;}

        if (deck.isEmpty()) {deck = deckBuilder();}

        return newPlayerCard;

    }

    public static Integer drawCardDealer(ArrayList<Integer> deck) {
        Random random = new Random();
        int randomNumber = random.nextInt(deck.size());

        newDealerCard = deck.get(randomNumber);
        deck.remove(randomNumber);

        dealerHand.add(newDealerCard);

        for (int i = 0; 1 < (dealerHand.size() - 1); i++) {
            dealerSum += dealerHand.get(i);
        }

        if (newDealerCard == 11) {dealerAces ++;}

        if (deck.isEmpty()) {deck = deckBuilder();}

        return newDealerCard;
    }
}