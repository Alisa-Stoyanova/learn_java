package jnk.praktika.aufgabe3;

import java.util.Scanner;

public class Snake {
    private int width = 10;
    private int height = 15;
    private int x = height / 2 - 1; // field 8x13 x = 1
    private int y = width / 2 - 1; // y = 1

    public static void main(String[] args) {
        Snake snake = new Snake();
        snake.play();
    }

    public void print() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 || i == width - 1) {
                    System.out.print("#");
                } else {
                    if (j == 0 || j == height - 1) {
                        System.out.print("#");
                    } else {
                        if (i == y && j == x) {
                            System.out.print("x");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
            }
            System.out.print("\n");
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        print();
        System.out.println("Press: \'w\', \'s\', \'a\', \'d\' to move the snake or \'e\' tot end the game.");
        while (true) { // c != 'e'
            char direction = scanner.next().charAt(0);
            if (direction == 'e') {
                System.out.println("Game end.");
                break;
            }
            switch (direction) {
                case 'w': // up
                    if (y != 1) {
                        y--;
                    }
                    break;
                case 's': // down
                    if (y != height - 1) {
                        y++;
                    }
                    break;
                case 'a': // left
                    if (x != 1) {
                        x--;
                    }
                    break;
                case 'd': // right
                    if (x != width - 1) {
                        x++;
                    }
                    break;
                default:
                    System.out.println("Input should be: \'w\', \'s\', \'a\', \'d\' or \'e\'!");
                    break;
            }
            print();
        }
    }
}
