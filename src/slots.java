import java.util.Scanner;
import java.util.Random;

public class slots {

    static String[] slotSymbols = {"7", "\uD83C\uDF52","\uD83C\uDF4D","\uD83C\uDF4C", "\uD83E\uDD5D", "\uD83D\uDC27","\uD83C\uDF4F","\uD83C\uDF47","\uD83C\uDF4B\u200D","❗"};
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();



    public static void main(String[] args){

        System.out.println("Welcome to the Slot machine, insert name, Good luck!");

        while (true){
            System.out.print("Do you want to spin the wheel? yes or no:  ");
            String choice = scanner.nextLine();
            switch (choice){
                case "yes":
                    String slot1 = slotSymbols[random.nextInt(8)];
                    String slot2 = slotSymbols[random.nextInt(8)];
                    String slot3 = slotSymbols[random.nextInt(8)];
                    String[] result = {slot1, slot2, slot3};

                    if (result[1]==result[2] && result[1]==result[0] && result[1].equals("7")){

                        System.out.println("  You hit the Jackpot!");
                        System.out.println(" ============ ");
                        System.out.println("| "+result[0] + "   " + result[1] + "   " + result[2] + " |");
                        System.out.println(" ============ ");
                        break;
                    }else if (result[1]==result[2] && result[1]==result[0]){
                        System.out.println("  You win!");
                        System.out.println(" =========== ");
                        System.out.println("| "+result[0] + "   " + result[1] + "   " + result[2] + " |");
                        System.out.println(" =========== ");
                        break;
                    }else{
                        System.out.println("  You lose!");
                        System.out.println(" =========== ");
                        System.out.println("| "+result[0] + "   " + result[1] + "   " + result[2] + " |");
                        System.out.println(" =========== ");
                        break;
                    }
                case "no":
                    System.out.println("Cashing out already? Goodbye! ");
                    return;
            }
        }
    }
}
