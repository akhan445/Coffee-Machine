package machine;
import java.util.Scanner;

class Machine {

    int water;
    int milk;
    int coffeeBeans;
    int cash;
    int cups;

    public Machine(int water, int milk, int coffeeBeans, int cash, int cups) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cash = cash;
        this.cups = cups;
    }
    //Getter Methods
    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCash() {
        return cash;
    }

    public int getCups() {
        return cups;
    }

    //Setter Methods
    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    //Methods
    public void printStatus() {
        System.out.print("Coffee Machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                cash + " of money\n");
    }

    public static boolean checkMachine(String drink, int water, int milk, int coffeeBeans, int cups) {

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
                if (coffeeBeans < 16) {
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
                if (coffeeBeans < 20) {
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
                if (coffeeBeans < 12) {
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

    public void makeDrink(String drink) {
        switch (drink) {
            case "1":
                this.setWater(this.getWater()-250);
                this.setCoffeeBeans(this.getCoffeeBeans()-16);
                this.setCups(this.getCups()-1);
                this.setCash(this.getCash()+4);
                break;
            case "2":
                this.setWater(this.getWater()-350);
                this.setMilk(this.getMilk()-75);
                this.setCoffeeBeans(this.getCoffeeBeans()-20);
                this.setCups(this.getCups()-1);
                this.setCash(this.getCash()+7);
//                waterInMachine -= 350;
//                milkInMachine -= 75;
//                beansInMachine -= 20;
//                cups--;
//                cashInMachine += 7;
                break;
            case "3":
                this.setWater(this.getWater()-200);
                this.setMilk(this.getMilk()-100);
                this.setCoffeeBeans(this.getCoffeeBeans()-12);
                this.setCups(this.getCups()-1);
                this.setCash(this.getCash()+6);
//                waterInMachine -= 200;
//                milkInMachine -= 100;
//                beansInMachine -= 12;
//                cups--;
//                cashInMachine += 6;
                break;
            case "back":
                System.out.println("returning to main menu...");
                break;
            default:
                System.out.println("Invalid entry.. must be 1- espresso, 2- latte, 3- cappuccino, returning to main menu");
        }
    }

    public void fillMachine(int water, int milk, int coffeeBeans, int cups) {
        this.setWater(this.getWater() + water);
        this.setMilk(this.getMilk() + milk);
        this.setCoffeeBeans(this.getCoffeeBeans() + coffeeBeans);
        this.setCups(this.getCups() + cups);
    }

    public void withdrawCash() {
        System.out.println("I gave you $" + this.getCash());
        this.setCash(0);
    }
}
