package com.company;

import java.util.Scanner;

public class CoffeMachine {
    Component[] store;
    Component[] storeHistory;
    double totalPrice;
    Scanner scan;

    public CoffeMachine() {
        this.store = new Component[]{
                new Component("milk", 5, 10),
                new Component("tea", 2, 100),
                new Component("cofee", 80, 5),
                new Component("chockolate", 12, 5),
                new Component("Shugar", 3, 10)
        };
        this.storeHistory = new Component[]{
                new Component("milk", 5, 10),
                new Component("tea", 2, 100),
                new Component("cofee", 80, 5),
                new Component("chockolate", 12, 5),
                new Component("Shugar", 3, 10)
        };
        scan = new Scanner(System.in);
        totalPrice = 0;
    }

    public void onCoffeMachine() {
        int choise = 0;
        System.out.println("Welcome, dear customer!");
        do {
            System.out.println("\nEnter: 1.Report, 2.Sale, 3.Add component, 0.Exit");
            choise = scan.nextInt();

            switch (choise) {
                case 1:
                    report();
                    break;
                case 2:
                    sale();
                    break;
                case 3:
                    addComponents();
                    break;
                case 0:
                    System.out.println("The work is stop.");
                    break;
                default:
                    System.out.println("Error,incorect choose");
            }


        } while (choise != 0);

    }

    private void addComponents() {
    }

    private void sale() {
        int chooseDrink = 0;
        int chooseAccept;
        int chooseShugar;
        int chooseMilk;

        do {
            System.out.println("\nWelcome! Enter your choose:");
            System.out.println("          1.Milk, 2.Tea, 3.Coffee, 4.Chocolate, 0.Exit");
            chooseDrink = scan.nextInt();
            switch (chooseDrink) {
                case 1:
                    System.out.printf("Price: %.2f$\n", 0.2 * store[0].coast);
                    System.out.println("Enter: 1.Accept, 0.Cancel");
                    chooseAccept = scan.nextInt();
                    if (chooseAccept == 1) {
                        totalPrice += 0.2 * store[0].coast;
                        System.out.println("Enjoy!");
                        store[0].amount -= 0.2;
                    }
                    break;
                case 2:
                    System.out.println("Enter: 1.With shugar, 0.Shugar free.");
                    chooseShugar = scan.nextInt();
                    double teaPrice = store[1].coast + store[4].coast * 0.02 * chooseShugar;
                    System.out.printf("Price: %.2f$\n", teaPrice);
                    System.out.println("Enter: 1.Accept, 0.Cancel");
                    chooseAccept = scan.nextInt();
                    if (chooseAccept == 1) {
                        System.out.println("Enjoy!");
                        totalPrice += teaPrice;
                        store[1].amount -= 1;
                        store[4].amount -= 0.02 * chooseShugar;
                    }
                    break;
                case 3:
                    int choiseCofee;
                    int choiseShugar;

                    System.out.println("Enter:1.Regular cofee,2.Double cofee");
                    choiseCofee = scan.nextInt();
                    System.out.println("How much spoons of shugar do you want: 1.one spoon,2.two spoons,0.no shugar");
                    choiseShugar = scan.nextInt();
                    System.out.println("you want with milk?: 1.With milk, 0.No milk.");
                    chooseMilk = scan.nextInt();
                    double coffeePrice = store[2].coast * 0.01 * choiseCofee + store[4].coast * 0.01 * choiseShugar
                            + 0.02 * chooseMilk * store[0].coast;
                    System.out.printf("Price: %.2f$\n", coffeePrice);
                    System.out.println("Enter: 1.Accept, 0.Cancel");
                    chooseAccept = scan.nextInt();
                    if (chooseAccept == 1) {
                        totalPrice += coffeePrice;
                        System.out.println("Enjoy!");
                        store[2].amount -= 0.01 * choiseCofee;
                        store[4].amount -= 0.01 * choiseShugar;
                        store[0].amount -= 0.02 * chooseMilk;
                    }
                    break;
                case 4:
                    System.out.println("you want with milk?: 1.With milk, 0.No milk.");
                    chooseMilk = scan.nextInt();
                    double chokolatePrise = 0.2 * store[3].coast + 0.02 * chooseMilk * store[0].coast;
                    System.out.printf("Price: %.2f$\n", chokolatePrise);
                    System.out.println("Enter: 1.Accept, 0.Cancel");
                    chooseAccept = scan.nextInt();
                    if (chooseAccept == 1) {
                        totalPrice += chokolatePrise;
                        System.out.println("Enjoy!");
                        store[3].amount -= 0.2;
                        store[0].amount -= 0.02 * chooseMilk;
                    }
                    break;
                case 0:
                    System.out.println("Come back to Main menu.");
                    break;
                default:
                    System.out.println("Error,incorrect choose");
            }

        } while (chooseDrink != 0);
    }

    private void report() {
        double controlIncome = 0;
        System.out.println("Now on the store:");
        for (int i = 0; i < store.length; i++) {
            System.out.println(store[i]);
            controlIncome += (storeHistory[i].amount - store[i].amount) * store[i].coast;
        }
        System.out.printf("Income = %.2f$\n", totalPrice);
        System.out.printf("Control income = %.2f$\n", controlIncome);
        System.out.printf("Profit = %.2f$\n", controlIncome * 0.45);
    }
}
