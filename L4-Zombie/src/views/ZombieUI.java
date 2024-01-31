package views;

import java.util.Random;

public class ZombieUI {

    static Random random = new Random();
    public int displayMainMenu() {
        int selectedOption;

        do {
            Console.writeLn("Select a menu option: ", Console.TextColor.BLUE);

            Console.writeLn("""
                    1. Generate 1 zombie
                    2. Generate some zombies
                    3. Generate n zombies
                    4. Exit
                    """);

            selectedOption = Console.getIntInput("Your selection", Console.TextColor.CYAN);

            if (selectedOption < 1 || selectedOption > 4) {
                Console.writeLn("Invalid option, choose 1-4 only!", Console.TextColor.RED);
                selectedOption = -1; // invalid input, repeat
            }

        } while (selectedOption == -1);

        return selectedOption;

    }

    public int numberOfZombies(){
        return Console.getIntInput("How many zombies are there: ");
    }

    // All zombie info
    public int getNumberOfArms(){
        return random.nextInt(2) + 1;
    }

    public int getNumberOfLegs(){
        return random.nextInt(2) + 1;
    }

    // Walker info
    public int getWalkerHP(){
        return 15 + random.nextInt(16);
    }

    public int getWalkerSpeed(){
        return 6 + random.nextInt(5);
    }

    // Runner info
    public int getRunnerHP(){
        return 10 + random.nextInt(13);
    }

    public int getRunnerSpeed(){
        return 15 + random.nextInt(11);
    }

    // Tank info
    public int getTankHP(){
        return 45 + random.nextInt(26);
    }

    public int getTankSpeed(){
        return 4 + random.nextInt(5);
    }

}
