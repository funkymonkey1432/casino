import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class blackJack {

    static ArrayList<Integer> playerHand = new ArrayList<>();
    static ArrayList<Integer> dealerHand = new ArrayList<>();

    static int playerSum = 0;
    static int playerAces = 0;

    static int newPlayerCard;
    static int newDealerCard;

    public static void main (String [] args) {
        Random random = new Random();

        int money = Main.money ;
        int bet = 0;





        ArrayList<Integer> deck = deckBuilder();
        drawCardPlayer(deck);



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
        return newPlayerCard;
    }

    public static Integer drawCardDealer(ArrayList<Integer> deck) {
        Random random = new Random();
        int randomNumber = random.nextInt(deck.size());
        newDealerCard = deck.get(randomNumber);
        deck.remove(randomNumber);
        System.out.println("you drew a " + newDealerCard);
        dealerHand.add(newDealerCard);
        return newDealerCard;
    }
}