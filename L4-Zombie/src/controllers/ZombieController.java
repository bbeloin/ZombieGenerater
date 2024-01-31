package controllers;

import models.*;
import views.*;
import java.util.ArrayList;
import java.util.Random;

public class ZombieController {
    private static ArrayList<Zombie> zombies = new ArrayList<>();

    static ZombieUI ui = new ZombieUI();
    static Random random = new Random();

    public static void run(){

        boolean usingProgram = true;


        while (usingProgram) {
            int menuItem = ui.displayMainMenu();

            switch (menuItem) {
                case 1:
                    displayAllZombies();
                    break;
                case 2:
                    int randomZombie = random.nextInt(10) + 1;

                    for (int i = 0; i < randomZombie; i++) {
                        zombieCalls();
                    }

                    for (int i = 0; i < randomZombie; i++) {
                        displayAllZombies();
                    }

                    break;
                case 3:
                    int num = ui.numberOfZombies();

                    for (int i = 0; i < num; i++) {
                        zombieCalls();
                    }

                    for (int i = 0; i < num; i++) {
                        displayAllZombies();
                    }

                    break;
                case 4:
                    usingProgram = false;
                    ArrayList<Zombie> zombies = new ArrayList<>();
                    break;
            }
        }
    }

    public static void createWalker(){

        int arms = ui.getNumberOfArms();
        int legs = ui.getNumberOfLegs();
        int _HP = ui.getWalkerHP();
        int speed = ui.getWalkerSpeed();

        Walker walker = new Walker(arms, legs, _HP, speed);

        zombies.add(walker);
    }

    public static void createRunner(){

        int arms = ui.getNumberOfArms();
        int legs = ui.getNumberOfLegs();
        int _HP = ui.getRunnerHP();
        int speed = ui.getRunnerSpeed();

        Runner runner = new Runner(arms, legs, _HP, speed);

        zombies.add(runner);
    }

    public static void createTank(){

        int arms = ui.getNumberOfArms();
        int legs = ui.getNumberOfLegs();
        int _HP = ui.getTankHP();
        int speed = ui.getTankSpeed();

        Tank tank = new Tank(arms, legs, _HP, speed);

        zombies.add(tank);
    }

    public static void zombieCalls(){
        createWalker();
        createRunner();
        createTank();
    }

    public static void  displayAllZombies(){

        if (zombies.isEmpty()){
            zombieCalls();
        }

        Zombie z = zombies.get(random.nextInt(zombies.size() + 1));

        int roll = z.roll(1, 20);
        String hitChance = z.attackType(roll);
        int damage = z.attack(roll);

        System.out.println("\n" + z);
        System.out.println("The roll was a " + roll + ", it " + hitChance + ". It did " + damage + " damage.");

    }

}
