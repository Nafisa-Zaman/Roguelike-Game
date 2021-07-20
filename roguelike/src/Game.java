import java.awt.Menu;
import java.util.Random;
import java.util.Scanner;

public class Game {

    // constants
    int WIDTH ;
    int HEIGHT;
    private final static String WALL_CHARACTER = "M";
    private final static String EMPTY_CHARACTER = " ";

    private final Scanner console = new Scanner(System.in);
    private Hero hero;
    private Treasure treasure;
    private Treasure treasureTwo;
    private boolean isOver;
    Menu menu;


    public void run() {

        while (!isOver) {
            printWorld();
            move();
        }
        printWorld();
    }

    public void setUp() {
        System.out.print("What is the name of your hero?: ");
        String name = console.nextLine();

        System.out.print("Which symbol will you choose for your hero?:");
        char symbol = console.next().charAt(0); //(0) takes the first symbol inputted even if there are multiple

        System.out.print("What size will your world be?:");
        WIDTH = console.nextInt();
        HEIGHT = console.nextInt();


        Random rand = new Random();
        int x = rand.nextInt(WIDTH);
        int y = rand.nextInt(WIDTH);

        hero = new Hero(symbol, name, x, y);




        do {
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(WIDTH);
        } while (x == hero.getX() && y == hero.getY());

        treasure = new Treasure(x, y);
        treasure = new Treasure(x, y);

        do {
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(WIDTH);
        } while (x == treasure.getX() &&  y == treasure.getY());


    }



    private void printWorld() {
        // top wall border
        System.out.println(WALL_CHARACTER.repeat(WIDTH + 2));

        for (int row = 0; row < WIDTH; row++) {
            // left wall border
            System.out.print(WALL_CHARACTER);
            for (int col = 0; col < WIDTH; col++) {
                if (row == hero.getY() && col == hero.getX()) {
                    System.out.print(hero.getSymbol());
                } else if (row == treasure.getY() && col == treasure.getX()) {
                    System.out.print("T");
                }
                else {
                    System.out.print(EMPTY_CHARACTER);
                }
            }

            // right wall border
            System.out.println(WALL_CHARACTER);
        }

        // bottom wall border
        System.out.println(WALL_CHARACTER.repeat(WIDTH + 2));
    }

    private void move() {

        System.out.print(hero.getName() + ", move [WASD]: ");
        String move = console.nextLine().trim().toUpperCase();

        if (move.length() != 1) {
            return;
        }

        switch (move.charAt(0)) {
            case 'W':
                hero.moveUp();
                break;
            case 'A':
                hero.moveLeft();
                break;
            case 'S':
                hero.moveDown();
                break;
            case 'D':
                hero.moveRight();
                break;
        }

        if (hero.getX() < 0 || hero.getX() >= WIDTH
                || hero.getY() < 0 || hero.getY() >= WIDTH) {
            System.out.println(hero.getName() + " touched lava! You lose.");
            isOver = true;
        } else if (hero.getX() == treasure.getX() && hero.getY() == treasure.getY()) {
            System.out.println(hero.getName() + " found the treasure! You win.");
            isOver = true;
        }
    }
}
