import java.util.Scanner;

public class Main {
    public static void main (String [] args) {
        Scanner Input = new Scanner(System.in);

        //Defining stuff
        String[] thingsToDo = {"Roulette", "Black Jack", "Slot Machine", "ATM", "Exit casino"};
        int money = 100;
        int bankAccount = 1400;
        String name;
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
                case "2": //Black Jack
                    //blackJack.main();
                case "3": //Slots
                    //slots.main();
                case "4": //ATM
                    //ATM.main();
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
