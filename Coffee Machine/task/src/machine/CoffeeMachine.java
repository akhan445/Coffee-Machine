package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int waterProCup = 200;
        int milkProCup = 50;
        int beansProCup = 15;

        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterInMachine = input.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkInMachine = input.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beansInMachine = input.nextInt();

        System.out.println("Write how many cups of coffee you will need: ");
        int cups = input.nextInt();

        int waterInMachineAreEnoughForCups = waterInMachine / waterProCup;
        int milkInMachineAreEnoughForCups = milkInMachine / milkProCup;
        int beansInMachineAreEnoughForCups = beansInMachine / beansProCup;


        int maxPossibleCups;

        if (waterInMachineAreEnoughForCups <= milkInMachineAreEnoughForCups && waterInMachineAreEnoughForCups <= beansInMachineAreEnoughForCups) {
            maxPossibleCups = waterInMachineAreEnoughForCups;
        } else if (milkInMachineAreEnoughForCups <= waterInMachineAreEnoughForCups && milkInMachineAreEnoughForCups <= beansInMachineAreEnoughForCups) {
            maxPossibleCups = milkInMachineAreEnoughForCups;
        } else {
            maxPossibleCups = beansInMachineAreEnoughForCups;
        }


        if (cups > maxPossibleCups) {
            System.out.println("No, I can make only " + maxPossibleCups + " cup(s) of coffee");
        } else if (cups == maxPossibleCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxPossibleCups - cups) + " more than that)");
        }

    }
}
