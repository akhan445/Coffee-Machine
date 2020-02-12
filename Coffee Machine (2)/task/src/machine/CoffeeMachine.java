package machine;

import javax.crypto.Mac;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
     runMachine();
    }



    public static void runMachine(){

        Scanner sc = new Scanner(System.in);

        //initialize values in machine
        Machine machine = new Machine(400, 540, 120, 550, 9);

        String action = sc.nextLine();
        while (!action.equals("exit")) {
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1- espresso, 2- latte, 3- cappuccino, back - to main menu");
                    String drink = sc.nextLine();
                    boolean checkIngredients = machine.checkMachine(drink, machine.water, machine.milk, machine.coffeeBeans, machine.cups);

                    if (checkIngredients) {
                        machine.makeDrink(drink);
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int addWater = sc.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    int addMilk = sc.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int addBeans = sc.nextInt();
                    System.out.println("Write how many disposable cups do you want to add:");
                    int addCups = sc.nextInt();
                    sc.nextLine();

                    machine.fillMachine(addWater, addMilk, addBeans, addCups);
                    break;

                case "take":
                    machine.withdrawCash();
                    break;

                case "remaining":
                    machine.printStatus();
                    break;
                default:
                    System.out.println("\nInvalid entry.. Please enter the correct command");
                    break;
            }
            System.out.println("\nWrite action (buy, fill, take, remaining, exit) :");
            action = sc.nextLine();
        }


//        int water = 200 * cups;         // 200 ml per cup
//        int milk = 50 * cups;           // 50 ml per cup
//        int beans = 15 * cups;          // 15 g per cup
//
//        int w = waterInMachine/200;
//        int m = milkInMachine/50;
//        int b = beansInMachine/15;
//        int capacity;
//
//        if (w <= m && w <= b) {
//            capacity = w;
//        }
//        else if (m < b) {
//            capacity = m;
//        }
//        else {
//            capacity = b;
//        }
//
//        //Desired amount is more than coffee machine can make
//        if (waterInMachine < water || milkInMachine < milk || beansInMachine < beans) {
//
//            System.out.println("No, I can only make " + capacity + " cup(s) of coffee");
//        }
//        else if (capacity == cups) {
//            System.out.println("Yes, I can make that amount of coffee");
//        }
//        else {
//            int extra = capacity - cups;
//            System.out.println("Yes, I can make that amount of coffee (and even " + extra + " more than that)");
//
//        }


    }


}
