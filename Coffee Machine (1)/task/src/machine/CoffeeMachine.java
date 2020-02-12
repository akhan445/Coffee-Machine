package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //initialize values in machine
        int cashInMachine = 550;
        int waterInMachine = 400;
        int milkInMachine = 540;
        int beansInMachine = 120;
        int cups = 9;

        System.out.println("Write action (buy, fill, take, remaining, exit) :");
        String action = sc.nextLine();

        while (!action.equals("exit")) {
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1- espresso, 2- latte, 3- cappuccino, back - to main menu");
                    String drink = sc.nextLine();
                    boolean makeCoffee = checkMachine(drink, waterInMachine, milkInMachine, beansInMachine, cashInMachine);

                    if (makeCoffee) {
                        switch (drink) {
                            case "1":
                                waterInMachine -= 250;
                                beansInMachine -= 16;
                                cups--;
                                cashInMachine += 4;
                                break;
                            case "2":
                                waterInMachine -= 350;
                                milkInMachine -= 75;
                                beansInMachine -= 20;
                                cups--;
                                cashInMachine += 7;
                                break;
                            case "3":
                                waterInMachine -= 200;
                                milkInMachine -= 100;
                                beansInMachine -= 12;
                                cups--;
                                cashInMachine += 6;
                                break;
                            case "back":
                                System.out.println("returning to main menu...");
                                break;
                            default:
                                System.out.println("Invalid entry.. must be 1- espresso, 2- latte, 3- cappuccino, returning to main menu");
                        }
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

                    waterInMachine += addWater;
                    milkInMachine += addMilk;
                    beansInMachine += addBeans;
                    cups += addCups;
                    break;

                case "take":
                    System.out.println("I gave you $" + cashInMachine);
                    cashInMachine = 0;
                    break;
                case "remaining":
                    printState(waterInMachine, milkInMachine, beansInMachine, cups, cashInMachine);
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

    public static void printState(int waterInMachine, int milkInMachine, int beansInMachine, int cups, int cashInMachine) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(waterInMachine + " of water");
        System.out.println(milkInMachine + " of milk");
        System.out.println(beansInMachine + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(cashInMachine + " of money");
    }

    public static boolean checkMachine(String drink, int water, int milk, int beans, int cups) {

        if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        switch (drink) {
            case "1":
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                    return false;
                }
                if (beans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return false;
                }
                break;
            case "2":
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                    return false;
                }
                if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    return false;
                }
                if (beans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return false;
                }
                break;
            case "3":
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                    return false;
                }
                if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    return false;
                }
                if (beans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return false;
                }
                break;
            default:
                return true;

        }
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }
}
