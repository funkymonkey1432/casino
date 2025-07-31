import java.util.Scanner;

public class Main {
    static String name;
    static int bankAccount = 1400;
    static int money = 100;

    public static void main (String [] args) {
        Scanner Input = new Scanner(System.in);

        //Defining stuff
        String[] thingsToDo = {"Roulette", "Black Jack", "Slot Machine", "ATM", "Exit casino"};
        String activity;
        boolean playing = true;

        //welcome code
        System.out.println("============================");
        System.out.println("    welcome to the casino   ");
        System.out.println("============================");
        System.out.print("\nwhat is your name: ");
        name = Input.nextLine();
        System.out.println("hello " + name + ".");

        while (playing) {
            printGames(thingsToDo);
            System.out.print("would you like to do(inter the number): ");
            activity = Input.nextLine();

            switch (activity) {
                case "1": //Roulette
                    //roulette.main();
                    break;
                case "2": //Black Jack
                    //blackJack.main();
                    break;
                case "3": //Slots
                    //slots.main();
                    break;
                case "4": //ATM
                    ATM.main(new String[0]);
                    break;
                case "5": //Exit
                    playing = false;
            }
        }
    }
    public static void printGames(String[] thingsToDo) {
        System.out.print("\nthings to do");

        for (int i = 0; i<thingsToDo.length; i++) {
            System.out.println((i + 1) + ". " + thingsToDo[i]);
        }
    }
}
