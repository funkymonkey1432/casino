import java.util.Scanner;

public class Main {
    static String name;
    static int bankAccount = 1400;
    static int money = 100;

    public static void main (String [] args) {
        Scanner Input = new Scanner(System.in);

        //Defining stuff
        String[] thingsToDo = {"Roulette", "Black Jack", "Slot Machine", "ATM", "other games", "Exit casino"};
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
            System.out.println("you have: $" + money + " on hand and \n $" + bankAccount + " in your bank account. \n");
            printGames(thingsToDo);
            System.out.print("what would you like to do(inter the number): ");
            activity = Input.nextLine();

            switch (activity) {
                case "1": { //Roulette
                        roulette.main(new String[0]);}
                        break;
                case "2": { //Black Jack
                        blackJack.main(new String[0]);}
                        break;
                case "3": { //Slots
                        slots.main(new String[0]);}
                        break;
                case "4": { //ATM
                        ATM.main(new String[0]);}
                        break;
                case "5": { //other games
                        System.out.println("╔═══════════════════════╗");
                        System.out.println("║   Games Coming Soon!  ║");
                        System.out.println("╚═══════════════════════╝");}
                        break;
                case "6": {//Exit
                    if (money+bankAccount-ATM.loanAmount<1500){
                        System.out.println("You lost $"+(1500-Math.abs(money+bankAccount-ATM.loanAmount))+".");
                    }else if (money+bankAccount-ATM.loanAmount>1500){
                        System.out.println("You won $"+(Math.abs(money+bankAccount-ATM.loanAmount)-1500)+".");
                    }else{
                        System.out.println("You broke even");
                    }
                        playing = false;}
                        break;
            }
        }
    }
    public static void printGames(String[] thingsToDo) {
        System.out.println("\nthings to do");

        for (int i = 0; i<thingsToDo.length; i++) {
            System.out.println((i + 1) + ". " + thingsToDo[i]);
        }
    }
}
