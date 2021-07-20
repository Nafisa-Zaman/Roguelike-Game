

import java.util.Scanner;


public class Menu {
    public static final Scanner scanner = new Scanner(System.in);


        public void start() {
            Game game = new Game();
            System.out.println("Welcome to the Game!");
            System.out.println("1. Set Up Game");
            System.out.println("2. Play Game");
            System.out.println("3. Exit");
            int response = scanner.nextInt();
            do {
                switch (response) {
                    case 1:
                        setUp();
                        response = 5;
                        break;

                    case 2:
                        runGame();
                        response = 5;
                        break;

                    case 3:
                        Exit();
                        response = 5;
                        break;

                    default:
                        System.out.println("Please Choose a Valid Option")
                        ;

                }
            }
            while (response != 5);

            }





    public static void setUp () {

        }


    public static void runGame() {


    }

        public static void Exit () {

        }


    }


